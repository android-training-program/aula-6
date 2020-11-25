package pt.atp.bobi.presentation.ui.fragments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pt.atp.bobi.data.DogsAPIClient
import pt.atp.bobi.data.cb.DataRetrieved
import pt.atp.bobi.data.model.Breed

private const val TAG = "BreedsViewModel"

class BreedsViewModel : ViewModel(), DataRetrieved {

    private val _dogsViewModel = MutableLiveData<List<Breed>>()
    val dogsLiveData = _dogsViewModel

    fun loadDogs() {
        DogsAPIClient.getListOfBreeds(this)
    }

    //region DataRetrieved

    override fun onDataFetchedSuccess(breeds: List<Breed>) {
        Log.d(TAG, "onDataFetched Success | ${breeds.size} new breeds")
        _dogsViewModel.postValue(breeds)
    }

    override fun onDataFetchedFailed() {
        Log.e(TAG, "Unable to retrieve new data")
        _dogsViewModel.postValue(emptyList())
    }

    //endregion DataRetrieved
}
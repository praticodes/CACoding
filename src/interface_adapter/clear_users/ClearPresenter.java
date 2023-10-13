package interface_adapter.clear_users;

// TODO Complete me

import interface_adapter.ViewManagerModel;
import use_case.clear_users.ClearOutputData;
import use_case.clear_users.ClearOutputBoundary;
import interface_adapter.clear_users.ClearState;
import interface_adapter.ViewManagerModel;


public class ClearPresenter implements ClearOutputBoundary {
    private final ClearViewModel clearViewModel;
    private ViewManagerModel viewManagerModel;

    public ClearPresenter(ViewManagerModel viewManagerModel, ClearViewModel clearViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.clearViewModel = clearViewModel;
    }

    @Override
    public void prepareSuccessView(ClearOutputData response) {
        // On success, switch to the signup view.
        viewManagerModel.setActiveView(clearViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ClearState clearState = clearViewModel.getState();
        clearState.setMessageError(error);
        clearViewModel.firePropertyChanged();
    }
}

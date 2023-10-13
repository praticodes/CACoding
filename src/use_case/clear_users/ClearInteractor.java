package use_case.clear_users;

// TODO Complete me

public class ClearInteractor implements ClearInputBoundary{

    final ClearUserDataAccessInterface userDataAccessObject;
    final ClearOutputBoundary clearPresenter;

    public ClearInteractor(ClearUserDataAccessInterface userDataAccessInterface,
                           ClearOutputBoundary clearOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.clearPresenter = clearOutputBoundary;
    }

    @Override
    public void execute(ClearInputData clearInputData) {
        if (!userDataAccessObject.populated()) {
            clearPresenter.prepareFailView("There are no users to delete.");
        } else {
            userDataAccessObject.clear();
            ClearOutputData clearOutputData = new ClearOutputData("Successfully deleted all users.", false);
            clearPresenter.prepareSuccessView(clearOutputData);
        }
    }
}


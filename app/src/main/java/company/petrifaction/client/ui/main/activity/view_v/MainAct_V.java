package company.petrifaction.client.ui.main.activity.view_v;

import company.petrifaction.client.ui.base.BaseMvp_View;

public interface MainAct_V extends BaseMvp_View
{
    void signOutSuccess();
    void signOutFailure();
}
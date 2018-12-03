package selfmanagement;

import selfmanagement.controller.LoginController;
import selfmanagement.model.Account;
import selfmanagement.view.HomeView;

/**Mem
 *
 * @author izal
 */
public class SelfManagement {

    public static void main(String[] args) {
        Account account = new Account();
        HomeView homeView = new HomeView();
        LoginController loginController = new LoginController(homeView, account);
        loginController.initLogin();
    }
}

package GUI.Components;

import GUI.Styler;
import GUI.Views.SettingsView;
import Logger.Level;
import Logger.Logger;
import Server.ServerSettings;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class OptionBar {

    public MenuBar getMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.getStylesheets().add(Styler.globalCSS);
        menuBar.getStyleClass().add("background");
        Menu menuOptions = new Menu("Options");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(actionEvent -> {
            if (ServerSettings.isBackgroundPersistent()) {
                Platform.exit();
            } else {
                System.exit(0);
            }
            Logger.log(Level.INFO, "Exit event detected. ");
        });
        menuOptions.getItems().add(exitMenuItem);
        Menu menuBuild = new Menu("Build");
        Menu menuControl = new Menu("Control");
        Menu menuView = new Menu("View");
        menuBar.getMenus().addAll(menuOptions, menuBuild, menuControl, menuView);
        return menuBar;
    }
}
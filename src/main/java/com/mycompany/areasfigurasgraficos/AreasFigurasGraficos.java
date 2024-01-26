/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.areasfigurasgraficos;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import frontend.MenuJFrame;


/**
 *
 * @author toapa
 */
public class AreasFigurasGraficos {

    public static void main(String[] args) {
        FlatMaterialLighterIJTheme.setup();
        MenuJFrame menu = new MenuJFrame ();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);      
    }
}

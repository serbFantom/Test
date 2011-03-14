package com.serb.java2D;

/**
 * User: S.Bezuglyi
 * Date: Aug 16, 2010
 * Time: 4:01:39 PM
 * To change this template use File | Settings | File Templates.
 */
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * FormToTrayMinimizeSample
 *
 * @author Eugene Matyushkin aka Skipy
 */
public class FormToTrayMinimizeSample extends JFrame {

    /**
     * Constructs frame. Tray icon is constructed only if system tray is supported
     */
    public FormToTrayMinimizeSample() {
        super("Form-to-tray minimize sample");
        //
        Image image = Toolkit.getDefaultToolkit().
                createImage("/home/S.Bezuglyi/IdeaProjects/common_training/data/trayIcon.png");
        setIconImage(image);
        JLabel lbl;
        ActionListener exitAL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        if (SystemTray.isSupported()) {
            PopupMenu pm = new PopupMenu();
            MenuItem miExit = new MenuItem("Exit");
            miExit.addActionListener(exitAL);
            MenuItem miRestore = new MenuItem("Restore");
            MenuItem miEmpty = new MenuItem("Empty");
            miRestore.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    restoreWindow();
                }
            });
            pm.add(miRestore);
            pm.add(miEmpty);
            pm.addSeparator();
            pm.add(miExit);

            lbl = new JLabel("<html><font color=\"blue\">System tray is supported</font></html>");
            SystemTray st = SystemTray.getSystemTray();
            TrayIcon ti = new TrayIcon(image, "Double click to restore window", pm);
            ti.addMouseListener(new TrayMouseListener());
            try {
                st.add(ti);
                addWindowListener(new WindowMinimizeListener());
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        } else {
            lbl = new JLabel("<html><font color=\"red\">System tray is NOT supported</font></html>");
        }
        lbl.setVerticalAlignment(JLabel.CENTER);
        lbl.setHorizontalAlignment(JLabel.CENTER);
        JButton btn = new JButton("Click to close application");
        btn.addActionListener(exitAL);
        getContentPane().setBackground(Color.white);
        getContentPane().add(lbl, BorderLayout.CENTER);
        getContentPane().add(btn, BorderLayout.SOUTH);
        setSize(300, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    /**
     * Hides frame
     */
    private void hideWindow() {
        setVisible(false);
    }

    /**
     * Shows frame. Restores frame state (normal or maximized)
     */
    private void restoreWindow() {
        setVisible(true);
        setExtendedState(getExtendedState() & (JFrame.ICONIFIED ^ 0xFFFF));
        requestFocus();
    }

    /**
     * Mouse listener for tray icon. Restores frame on double click.
     */
    class TrayMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                restoreWindow();
            }
        }
    }

    /**
     * Window event listener. Hides frame in iconfying and window closing events
     */
    class WindowMinimizeListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            hideWindow();
        }
        @Override
        public void windowIconified(WindowEvent e) {
            hideWindow();
        }
    }

    /**
     * Runs test
     *
     * @param args test arguments
     */
    public static void main(String[] args) {
        new FormToTrayMinimizeSample().setVisible(true);
    }
}
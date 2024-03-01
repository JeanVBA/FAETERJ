package Ameaca.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmSplash extends JDialog implements ActionListener {
    private Timer timer;
    private long total, parcial;
    private JProgressBar progressBar;

    public FrmSplash() {
        setSize(new Dimension(420, 320));
        setLocationRelativeTo(null);
        setModal(true);
        setUndecorated(true);
        timer = new Timer(100, this);
        total = 0;
        parcial = 0;

        JLabel titulo = new JLabel("Ameacas");
        add(titulo, BorderLayout.NORTH);
        titulo.setBackground(new Color(113, 27, 27, 255));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setFont(new Font("Orbitron", Font.BOLD, 16));
        titulo.setBackground(Color.BLACK);
        titulo.setPreferredSize(new Dimension(0, 36));


        JLabel img = new JLabel();
        ImageIcon iconLogo = new ImageIcon("src/Resource/SplashArt.gif");
        img.setIcon(iconLogo);
        add(img, BorderLayout.CENTER);

        UIManager.put("ProgressBar.background", Color.lightGray);
        UIManager.put("ProgressBar.foreground", new Color(110, 20, 20));

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.DARK_GRAY);
        progressBar.setPreferredSize(new Dimension(367, 9));

        JPanel pnl = new JPanel();
        pnl.setPreferredSize(new Dimension(0, 30));
        add(pnl, BorderLayout.SOUTH);
        pnl.add(progressBar);
    }

    public void actionPerformed(ActionEvent ae) {
        parcial += 100;
        if (parcial > total)
            parcial = total;
        double perc = 100.0 * parcial / total;
        progressBar.setValue((int) perc);
        if (parcial >= total) {
            timer.stop();
            hide();
        }
    }

    private void start(long millis) {
        total = millis;
        parcial = 0;
        timer.start();
        show();
    }

    public static void executar(long millis) {
        FrmSplash frm = new FrmSplash();
        frm.start(millis);
    }
}
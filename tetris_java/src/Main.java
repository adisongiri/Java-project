import tetris.WindowGame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {
    public JPanel container = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Image img = new ImageIcon(this.getClass().getResource("/image.png")).getImage();
            g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
        }
    };
    JButton start;
    public Main() {
        Color btncolor = Color.decode("0x9044EC");
        setTitle("Tetris Game");
        setBounds(480,80 , 445, 629);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        container.setBorder(new EmptyBorder(5,5,5,5));
        container.setLayout(null);

        start = new JButton();
        start.setText("Start");
        start.setBounds(150,400,150,40);
        start.setForeground(Color.WHITE);
        start.setFont(new Font("Arial",Font.BOLD,20));
        start.setBackground(btncolor);
        start.setBorderPainted(false);
        start.setVisible(true);
        start.setLayout(null);
        container.add(start);

        //btn click code to move to game
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                WindowGame wg = new WindowGame();

            }
        });

        setVisible(true);
        setContentPane(container);
    }

    public static void main(String[] args) {
        Main obj = new Main();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MegaGameXO extends JFrame {
    static final int SIZE = 3;
    static final int DOTS_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '*';

    JButton[] buttons;
    final int[] coord = new int[2];

    public MegaGameXO(){
        setBounds(300,200,600,600);
        setTitle("XOmegaGame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Font font = new Font("Arial",Font.BOLD,24);
        buttons = new JButton[SIZE*SIZE];
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(SIZE,SIZE));
        for (int i = 0; i < SIZE*SIZE ; i++) {
            buttons[i] = new JButton("#"+i);
            buttons[i].setFont(font);
            final int temp = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttons[temp].setText(""+DOT_X);
                    int x = temp % SIZE +1;
                    int y = temp / SIZE +1;
                    System.out.println(x+" "+y);
                    coord[0] = x;
                    coord[1] = y;
                }
            });

            panel.add(buttons[i]);
        }

        add(panel);
        setVisible(true);
    }
}




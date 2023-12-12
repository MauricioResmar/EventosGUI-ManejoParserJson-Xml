package Eventos.SwingTax;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JTextPane pricePane;
    private JTextPane taxPane;
    private JTextPane totalPane;
    private JButton buttonCalculate;
    private JPanel taxPanel;

    public static void main(String[] args){

        //Instanciamos objeto del tipo Jframe y le damos un nombre:
        JFrame frame = new JFrame("SwingTax");

        // Le decimos a Jframe que instancie, nuestra Clase (MainForm) relacionadamente con el panel principal de nuestro formulario taxPanel
        frame.setContentPane(new MainForm().taxPanel);

        //Ahora debemos invocar al metodo frame.setVisible con el parámetro (true) de nuestro marco lo cual permite,
        //qué a partir de aquí, nuestra app se haga visible mediante una interfaz grafica GUI de mapa de bits tal cómo un array bidimensional.
        frame.setVisible(true);

        // Ésta linea, aún no la descifro. Pero al parecer es el metodo que cierra las operaciones referentes al Frame
        // y finaliza la interfaz grafica así como su proceso. Despues de probar, noto que despues de cerrar la interfaz gráfica
        // ésta linea finaliza el proceso del programa en el Ide, de lo contrario éste seguira corriendo aún despues de cerrar la interfaz.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // La Clase donde se ejecuta nuestro botón se llama igual que nuestra clase
    public MainForm() {
       buttonCalculate.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               double p = Double.parseDouble(pricePane.getText());
               double t = Double.parseDouble((taxPane.getText()));

               double result = p + (p / 100 * t);
               totalPane.setText(Double.toString(result));
           }
       });

        //Evento KeyListener de la Clase Swing util para atender el Evento (Cuando la persona deje de tipear o teclear)
        // en el input de un JTextPane haga esto o aquello. Notese que: También éste Evento, se encuentra dentro de MainForm(){}:

        /* pricePane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                String valorPrecio = pricePane.getText() + "ñ";
                pricePane.setText(valorPrecio);
            }
        });*/
    }
}


import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class FileDemonstration extends JFrame {

    private JTextArea outputArea; // utilizado para saída
    private JScrollPane scrollPane; // utilizado para fornecer rolagem para saída

    // confi gura a GUI
    public FileDemonstration() {
        super("Testing class File");

        outputArea = new JTextArea();

        // adiciona outputArea a scrollPane
        scrollPane = new JScrollPane(outputArea);

        add(scrollPane, BorderLayout.CENTER); // adiciona scrollPane a GUI

        setSize(400, 400); // configura o tamanho da GUI
        setVisible(true); // exibe a GUI

        analyzePath(); // cria e analisa o objeto File
    } // fim do construtor de FileDemonstration

    // permite que o usuário especifique o nome de arquivo ou diretório
    private File getFileOrDirectory() {
        // exibe o diálogo de arquivo para que o usuário possa escolher o arquivo a abrir
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(
                JFileChooser.FILES_AND_DIRECTORIES);

        int result = fileChooser.showOpenDialog(this);

        // se o usuário clicou no botão Cancel no diálogo, retorna
        if (result == JFileChooser.CANCEL_OPTION) {
            System.exit(1);
        }

        File fileName = fileChooser.getSelectedFile(); // obtém o arquivo

        // exibe erro se inválido
        if ((fileName == null) || (fileName.getName().equals(""))) {
            JOptionPane.showMessageDialog(this, "Invalid Name",
                    "Invalid Name", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // fim do if

        return fileName;
    } // fim do método getFile

    // exibe informações sobre o arquivo ou diretório que o usuário especifica
    public void analyzePath() {
        // cria o objeto File com base na entrada de usuário
        File name = getFileOrDirectory();

        if (name.exists()) // se o nome existir, gera saída das informações sobre ele
        {
            // exibe informações sobre o arquivo (ou diretório)
            outputArea.setText(String.format(
                    "%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
                    name.getName(), " exists",
                    (name.isFile() ? "is a file" : "is not a file"),
                    (name.isDirectory() ? "is a directory"
                    : "is not a directory"),
                    (name.isAbsolute() ? "is absolute path"
                    : "is not absolute path"), "Last modified: ",
                    name.lastModified(), "Length: ", name.length(),
                    "Path: ", name.getPath(), "Absolute path: ",
                    name.getAbsolutePath(), "Parent: ", name.getParent()));

            if (name.isDirectory()) // listagem de diretório de saída
            {
                String[] directory = name.list();
                outputArea.append("\n\nDirectory contents:\n");

                for (String directoryName : directory) {
                    outputArea.append(directoryName + "\n");
                }
            } // fim de else
        } // fim do if mais externo
        else // não se trata de um arquivo nem de um diretório, então imprime uma mensagem de erro
        {
            JOptionPane.showMessageDialog(this, name
                    + " does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    } 
}

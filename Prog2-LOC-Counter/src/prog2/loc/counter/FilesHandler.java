/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.loc.counter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.nio.file.*;

/**
 *
 * @author felipe
 */
public class FilesHandler extends JPanel
        implements ActionListener {

    static private final String NEW_LINE = "\n";
    JButton openButton;
    JButton saveButton;
    public static JTextArea log;
    JFileChooser fc;

    public FilesHandler() {
        super(new BorderLayout());

        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(5, 20);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        //Create a file chooser
        fc = new JFileChooser();

        //Uncomment one of the following lines to try a different
        //file selection mode.  The first allows just directories
        //to be selected (and, at least in the Java look and feel,
        //shown).  The second allows both files and directories
        //to be selected.  If you leave these lines commented out,
        //then the default mode (FILES_ONLY) will be used.
        //
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setCurrentDirectory(new File("."));
        //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //Create the open button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        openButton = new JButton("Open a Folder...",
                createImageIcon("images/Open16.gif"));
        openButton.addActionListener(this);

//        //Create the save button.  We use the image from the JLF
//        //Graphics Repository (but we extracted it from the jar).
//        saveButton = new JButton("Save a File...",
//                createImageIcon("images/Save16.gif"));
//        saveButton.addActionListener(this);
        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);
//        buttonPanel.add(saveButton);

        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
        setPreferredSize(new Dimension(900, 480));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(FilesHandler.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                log.append("Opening: " + file.getName() + "." + NEW_LINE);
                Counter counter = new Counter(getPathsArray(file.getPath()));
                log.append("Number of Classes: " + counter.getPathArray().size()
                        + NEW_LINE);
                log.append("Total number of methods: " + counter.countMethods()
                        + NEW_LINE);
                log.append("Total LOC: " + counter.countLOC() + NEW_LINE);
            } else {
                log.append("Open command cancelled by user." + NEW_LINE);
            }
            log.setCaretPosition(log.getDocument().getLength());

            //Handle save button action.
        } else if (e.getSource() == saveButton) {
            int returnVal = fc.showSaveDialog(FilesHandler.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would save the file.
                log.append("Saving: " + file.getName() + "." + NEW_LINE);
            } else {
                log.append("Save command cancelled by user." + NEW_LINE);
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     *
     * @param path
     * @return
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = FilesHandler.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public ArrayList<String> getPathsArray(String path) {
        ArrayList<String> arrayPaths = new ArrayList<>();
        try {
            Files.walk(Paths.get(path)).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    if (filePath.toString().endsWith("java")) {
                        System.out.println(filePath.toString());
                        arrayPaths.add(filePath.toString());
                    }
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(Prog2LOCCounter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayPaths;
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event dispatch thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("LOC Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new FilesHandler());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public JTextArea getLog() {
        return log;
    }

}

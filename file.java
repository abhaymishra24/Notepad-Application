
import java.io.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.*;
import java.nio.file.FileSystemNotFoundException;
import javax.xml.parsers.ParserConfigurationException;

public class Notepad extends Frame {

    Clipboard cBoard = getToolkit().getSystemClipboard();
    TextArea tArea;
    String fName;

Notepad()
    {
        gaListener gListen = new gaListener();
        addWindowListener(gListen);

        tArea = new TextArea();
        add(tArea);

        MenuBar mBar = new MenuBar();
        Menu fileMenu = new Menu ("File");

        MenuItem nOption = new MenuItem("New");
        MenuItem oOption = new MenuItem("Open");
        MenuItem sOption = new MenuItem("Save");
        MenuItem cOption = new MenuItem("Close");

        nOption.addActionListener(new Ne_option());
        fileMenu.add(nOption);

        oOption.addActionListener(new Op_option());
        fileMenu.add(oOption);

        sOption.addActionListener(new Sav_option());
        fileMenu.add(sOption);

        cOption.addActionListener(new Clos_option());
        fileMenu.add(cOption);

        mBar.add(fileMenu);

        Menu editMenu = new Menu("Edit");
        MenuItem cutOption = new MenuItem("Cut");
        MenuItem copyOption = new MenuItem("Copy");
        MenuItem pasteOption = new MenuItem("Paste");

        cutOption.addActionListener(new Cu_option());
        editMenu.add(cutOption);

        copyOption.addActionListener(new Cop_option());
        editMenu.add(copyOption);

        pasteOption.addActionListener(new Past_option());
        editMenu.add(pasteOption);

        mBar.add(editMenu);
        setMenuBar(mBar);

    setTitle("Notepad in Java");

    }

     class gaListener extends WindowAdapter{

        public void windowClosing(WindowEvent closeNotepad)
        {
            System.exit(0);
        }
     }

    class Ne_option implements ActionListener
    {
        public void actionPerformed(ActionEvent ne)
        {
            tArea.setText(" ");
        }
    }
    
    class Ope_option implements ActionListener 
    {
        public void actionPerformed(ActionEvent ope)
        {
            FileDialog fDialog = new FileDialog (Notepad.this, "Select a text file", FileDialog.LOAD);

            fDialog.show();

            if (fDialog.getFile() !=null)
            {
                fName = fDialog.getDirectory() + fDialog.getFile();
                setTitle(fName);
                ReadFile();
            }
            tArea.requestFocus();
        }
    }

class Clos_option implements ActionListener
    {
        public void actionPerformed(ActionEvent close_o)
        {
            System.exit(0);
        }
    }

class Sav_option implements ActionListener
    {
        public void actionPerformed(ActionEvent sav_o)
        {
            FileDialog fDialog = new FileDialog(Notepad.this, "Save the text file with .txt extension", FileDialog.SAVE);
            fDialog.show();

            if (fDialog.getFile() != null)
            {
                fName = fDialog.getDirectory() + fDialog.getFile();
            }
        }
    }

      





}
 

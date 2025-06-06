package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;


public class MainView extends JFrame {
    private final JButton importButton;
    private final JButton exportButton;
    private final JButton exitButton;
    private final JTextArea resultArea;
    private final JComboBox<String> sheetSelector;

    public MainView() {
        setTitle("Лабораторная работа 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel();
        importButton = new JButton("Импорт данных");
        exportButton = new JButton("Экспорт результатов");
        exitButton = new JButton("Выход");
        
        buttonPanel.add(importButton);
        buttonPanel.add(exportButton);
        buttonPanel.add(exitButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        sheetSelector = new JComboBox<>();
        sheetSelector.setEnabled(false);
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(buttonPanel, BorderLayout.CENTER);
        topPanel.add(sheetSelector, BorderLayout.EAST);
        
        getContentPane().add(topPanel, BorderLayout.NORTH);
    }

    public void setImportButtonListener(ActionListener listener) {
        importButton.addActionListener(listener);
    }

    public void setExportButtonListener(ActionListener listener) {
        exportButton.addActionListener(listener);
    }

    public void setExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }

    public void displayResults(String results) {
        resultArea.setText(results);
    }

    public File showFileOpenDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel Files", "xlsx"));
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public File showFileSaveDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel Files", "xlsx"));
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }
    
    public void updateSheetSelector(List<String> sheetNames) {
        sheetSelector.removeAllItems();
        for (String name : sheetNames) {
            sheetSelector.addItem(name);
        }
        sheetSelector.setEnabled(!sheetNames.isEmpty());
    }

    public int getSelectedSheetIndex() {
        return sheetSelector.getSelectedIndex();
    }

    public void setSheetChangeListener(ActionListener listener) {
        sheetSelector.addActionListener(listener);
    }
}


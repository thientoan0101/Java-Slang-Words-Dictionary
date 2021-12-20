/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author thien
 */
public class Menu extends javax.swing.JPanel {

    private HashMap<String, ArrayList<String>> dictionary = new HashMap<String, ArrayList<String>>();
    private String slangFile = "./src/main/java/com/company/slang.txt";
    private int selectedIndex;
    private DefaultTableModel model;
    /**
     * Creates new form Menu
     */
    public Menu() throws IOException {
        loadFromTextFile(slangFile);
        initComponents();
        loadDataIntoTable(dictionary);
    }

    public HashMap<String, ArrayList<String>> loadFromTextFile(String filename) throws IOException {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filename));
        } catch (IOException exc) {
            System.out.println("Error opening file");
            return dictionary;
        }
        String str;
        while (true) {
            str = br.readLine();
            if (str == null) {
                break;
            }
            String[] temp = str.split("`");
            String slang = temp[0];
            ArrayList<String> definitions = new ArrayList<String>(Arrays.asList(temp[1].split("\\| ")));
            if (dictionary.containsKey(slang) == true) {
                ArrayList<String> oldDefinition = dictionary.get(slang);
                definitions.addAll(oldDefinition);
            }
            dictionary.put(slang, definitions);
        }
        System.out.println("\n\nSuccessful");
        System.out.println("\n\ndictionary: " + dictionary.size());
        return dictionary;
    }

    public void loadDataIntoTable(HashMap<String, ArrayList<String>> map) {
        System.out.println("into load data into db");
        model = new DefaultTableModel();
        Vector headerColumn = new Vector();
        headerColumn.add("ID");
        headerColumn.add("Slang");
        headerColumn.add("Definition");

        model.setColumnIdentifiers(headerColumn);
        // set data
        int i = 0;
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {

            ArrayList<String> values = entry.getValue();
            System.out.print("\n" + i + ". " + entry.getKey() + ": ");
            for (String e : values) {
                i++;
                Vector row = new Vector();
                row.add(i);
                row.add(entry.getKey());
                row.add(e);
                model.addRow(row);
            }

        }

        slangTable.setModel(model);
        slangTable.getColumnModel().getColumn(0).setMaxWidth(45);
        slangTable.getColumnModel().getColumn(1).setMaxWidth(120);
        slangTable.getColumnModel().getColumn(1).setPreferredWidth(100);
//        table.getColumnModel().getColumn(1).setPreferredWidth(120);
//        table.getColumnModel().getColumn(2).setPreferredWidth(100);
//        tableStudent.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                jTableMouseClicked(evt);
//            }
//        });
    }
    public HashMap<String, ArrayList<String>> searchByKeySlang(String value) {
        String needle = value.toLowerCase();
        HashMap<String, ArrayList<String>> results = new HashMap<String, ArrayList<String>>();
        for(Map.Entry<String, ArrayList<String>> entry : dictionary.entrySet())
        {
            if (entry.getKey().toLowerCase().contains(needle)) {
                results.put(entry.getKey(), entry.getValue());
            }
        }
        return results;
    }


    public HashMap<String, ArrayList<String>> searchByDefinition(String value) {
        String needle = value.toLowerCase();
        HashMap<String, ArrayList<String>> results = new HashMap<String, ArrayList<String>>();

        for(Map.Entry<String, ArrayList<String>> entry : dictionary.entrySet())
        {
            boolean founded = false;
            ArrayList<String> tempDefi = new ArrayList<String>();
            ArrayList<String> values = entry.getValue();
            for (String e : values) {
                if (e.toLowerCase().contains(needle)) {
                    founded = true;
                    tempDefi.add(e);
                    System.out.println(entry.getKey() + ": founded value: " + e);
                }
            }
            if (founded) {
                results.put(entry.getKey(), tempDefi);
            }
        }
        return results;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPane = new javax.swing.JPanel();
        nameAppLabel = new javax.swing.JLabel();
        searchPane = new javax.swing.JPanel();
        searchLabel = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        searchComboBox = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JButton();
        historyButton = new javax.swing.JButton();
        tablePane = new javax.swing.JPanel();
        tableScrollPane = new javax.swing.JScrollPane();
        slangTable = new javax.swing.JTable();
        resetPane = new javax.swing.JPanel();
        refreshButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        leftPane = new javax.swing.JPanel();
        randomPane = new javax.swing.JPanel();
        randomButton = new javax.swing.JButton();
        randomLabel = new javax.swing.JLabel();
        detailPane = new javax.swing.JPanel();
        inputDetailPane = new javax.swing.JPanel();
        slangLabel = new javax.swing.JLabel();
        slangField = new javax.swing.JTextField();
        definiLabel = new javax.swing.JLabel();
        definiField = new javax.swing.JTextField();
        addEditPane = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        playPane = new javax.swing.JPanel();
        questionPane = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        questionLabel = new javax.swing.JLabel();
        answerPane = new javax.swing.JPanel();
        aButton = new javax.swing.JButton();
        bButton = new javax.swing.JButton();
        cButton = new javax.swing.JButton();
        dButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        stopButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();

        nameAppLabel.setText("JAVA SLANG WORDS DICTIONARY");

        searchLabel.setText("Keyword: ");

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        searchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Slang", "Definition", " " }));
        searchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchComboBoxActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });

        historyButton.setText("History");
        historyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPaneLayout = new javax.swing.GroupLayout(searchPane);
        searchPane.setLayout(searchPaneLayout);
        searchPaneLayout.setHorizontalGroup(
            searchPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(historyButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchPaneLayout.setVerticalGroup(
            searchPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(searchPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLabel)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(historyButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout headerPaneLayout = new javax.swing.GroupLayout(headerPane);
        headerPane.setLayout(headerPaneLayout);
        headerPaneLayout.setHorizontalGroup(
            headerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameAppLabel)
                .addGap(310, 310, 310))
        );
        headerPaneLayout.setVerticalGroup(
            headerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPaneLayout.createSequentialGroup()
                .addComponent(nameAppLabel)
                .addGap(10, 10, 10)
                .addComponent(searchPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        slangTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Index", "Slang", "Definition"
            }
        ));
        slangTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slangTableMouseClicked(evt);
            }
        });
        tableScrollPane.setViewportView(slangTable);
        if (slangTable.getColumnModel().getColumnCount() > 0) {
            slangTable.getColumnModel().getColumn(0).setResizable(false);
        }

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        resetPane.add(refreshButton);

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        resetPane.add(resetButton);

        javax.swing.GroupLayout tablePaneLayout = new javax.swing.GroupLayout(tablePane);
        tablePane.setLayout(tablePaneLayout);
        tablePaneLayout.setHorizontalGroup(
            tablePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resetPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(tablePaneLayout.createSequentialGroup()
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        tablePaneLayout.setVerticalGroup(
            tablePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePaneLayout.createSequentialGroup()
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        randomButton.setText("Random Slang");
        randomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout randomPaneLayout = new javax.swing.GroupLayout(randomPane);
        randomPane.setLayout(randomPaneLayout);
        randomPaneLayout.setHorizontalGroup(
            randomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(randomPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(randomButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(randomLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        randomPaneLayout.setVerticalGroup(
            randomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(randomPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(randomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(randomButton)
                    .addComponent(randomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        slangLabel.setText("Slang: ");

        definiLabel.setText("Definition:");

        javax.swing.GroupLayout inputDetailPaneLayout = new javax.swing.GroupLayout(inputDetailPane);
        inputDetailPane.setLayout(inputDetailPaneLayout);
        inputDetailPaneLayout.setHorizontalGroup(
            inputDetailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputDetailPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputDetailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(definiLabel)
                    .addComponent(slangLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputDetailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slangField)
                    .addComponent(definiField))
                .addContainerGap())
        );
        inputDetailPaneLayout.setVerticalGroup(
            inputDetailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputDetailPaneLayout.createSequentialGroup()
                .addGroup(inputDetailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slangField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slangLabel))
                .addGap(11, 11, 11)
                .addGroup(inputDetailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(definiLabel)
                    .addComponent(definiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        addEditPane.add(addButton);

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        addEditPane.add(editButton);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        addEditPane.add(deleteButton);

        javax.swing.GroupLayout detailPaneLayout = new javax.swing.GroupLayout(detailPane);
        detailPane.setLayout(detailPaneLayout);
        detailPaneLayout.setHorizontalGroup(
            detailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inputDetailPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addEditPane, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );
        detailPaneLayout.setVerticalGroup(
            detailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPaneLayout.createSequentialGroup()
                .addComponent(inputDetailPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(addEditPane, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        playPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton5.setText("Let's Play Quiz Game");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        questionLabel.setText("Question: ");

        javax.swing.GroupLayout questionPaneLayout = new javax.swing.GroupLayout(questionPane);
        questionPane.setLayout(questionPaneLayout);
        questionPaneLayout.setHorizontalGroup(
            questionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(questionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(questionPaneLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        questionPaneLayout.setVerticalGroup(
            questionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questionPaneLayout.createSequentialGroup()
                .addComponent(jButton5)
                .addGap(4, 4, 4)
                .addComponent(questionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        answerPane.setLayout(new java.awt.GridLayout(2, 2, 20, 10));

        aButton.setText("A. ");
        answerPane.add(aButton);

        bButton.setText("B. ");
        answerPane.add(bButton);

        cButton.setText("C. ");
        answerPane.add(cButton);

        dButton.setText("D. ");
        answerPane.add(dButton);

        stopButton.setText("Stop Game");
        jPanel1.add(stopButton);

        nextButton.setText("Next Question");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        jPanel1.add(nextButton);

        javax.swing.GroupLayout playPaneLayout = new javax.swing.GroupLayout(playPane);
        playPane.setLayout(playPaneLayout);
        playPaneLayout.setHorizontalGroup(
            playPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(questionPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(answerPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        playPaneLayout.setVerticalGroup(
            playPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playPaneLayout.createSequentialGroup()
                .addComponent(questionPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout leftPaneLayout = new javax.swing.GroupLayout(leftPane);
        leftPane.setLayout(leftPaneLayout);
        leftPaneLayout.setHorizontalGroup(
            leftPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(randomPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(detailPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftPaneLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(playPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftPaneLayout.setVerticalGroup(
            leftPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPaneLayout.createSequentialGroup()
                .addComponent(randomPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tablePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchComboBoxActionPerformed

    private void historyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_historyButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void randomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_randomButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextButtonActionPerformed

    private void slangTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slangTableMouseClicked
        selectedIndex = slangTable.getSelectedRow();

//        idField.setText(model.getValueAt(selectedIndex, 0).toString());
        slangField.setText(model.getValueAt(selectedIndex, 1).toString());
        definiField.setText(model.getValueAt(selectedIndex, 2).toString());
//        gpaField.setText(model.getValueAt(selectedIndex, 3).toString());
//        addressField.setText(model.getValueAt(selectedIndex, 4).toString());
//        imageField.setText(model.getValueAt(selectedIndex, 5).toString());
//        noteField.setText(model.getValueAt(selectedIndex, 6).toString());        // TODO add your handling code here:
    }//GEN-LAST:event_slangTableMouseClicked

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        // TODO add your handling code here:
        if (searchField.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Please enter something to search");
        }
        else {
            try {                               
                String keyword = searchField.getText().toString();                
                String typeToSearch = (String)searchComboBox.getSelectedItem();
                HashMap<String, ArrayList<String>> results = new HashMap<String, ArrayList<String>>();
                if (typeToSearch.equals("Definition")) {
                    results = searchByDefinition(keyword);
                    loadDataIntoTable(results);
                } else if (typeToSearch.equals("Slang")) {
                    results = searchByKeySlang(keyword);
                    loadDataIntoTable(results);
                }
                    

                
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Please Enter full information or valid field");
            }
        }

        
        
    }//GEN-LAST:event_searchButtonMouseClicked

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
        {  
            if (searchField.getText().equals("")) {        
                loadDataIntoTable(dictionary);
            } 
        }
    }//GEN-LAST:event_searchFieldKeyReleased

    public static void createAndShowGUI() throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Slang Words Dictionary");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Menu newContentPane = new Menu();
        newContentPane.setOpaque(true);

        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aButton;
    private javax.swing.JButton addButton;
    private javax.swing.JPanel addEditPane;
    private javax.swing.JPanel answerPane;
    private javax.swing.JButton bButton;
    private javax.swing.JButton cButton;
    private javax.swing.JButton dButton;
    private javax.swing.JTextField definiField;
    private javax.swing.JLabel definiLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel detailPane;
    private javax.swing.JButton editButton;
    private javax.swing.JPanel headerPane;
    private javax.swing.JButton historyButton;
    private javax.swing.JPanel inputDetailPane;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel leftPane;
    private javax.swing.JLabel nameAppLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JPanel playPane;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JPanel questionPane;
    private javax.swing.JButton randomButton;
    private javax.swing.JLabel randomLabel;
    private javax.swing.JPanel randomPane;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JPanel resetPane;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> searchComboBox;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel searchPane;
    private javax.swing.JTextField slangField;
    private javax.swing.JLabel slangLabel;
    private javax.swing.JTable slangTable;
    private javax.swing.JButton stopButton;
    private javax.swing.JPanel tablePane;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}

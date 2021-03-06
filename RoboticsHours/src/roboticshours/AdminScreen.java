package roboticshours;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Alan
 */
public class AdminScreen extends JFrame implements TableModelListener{ 
    static JFrame mainScreen;
    private Account account; 
    DefaultTableModel dataModel; 
    Border defaultBorder;
    
    /** * Creates new form AdminScreen */ 
    public AdminScreen() { 
        initComponents();
        defaultBorder = firstNameField.getBorder();
        ArrayList<Entry> entries = new ArrayList<>(); 
        for(Account a : Run.getAccountList()){ 
            entries.addAll(a.getEntries());
        } 
        Object[][] data = new Object[entries.size()][5]; 
        for(int i = 0; i < entries.size(); i++){ 
            Entry e = entries.get(i);
            Calendar d = e.getDate(); 
            Calendar dm = e.getDateModified(); 
            data[i][0] = false; 
            data[i][1] = e.getUser().getAccountName().replace("+", " "); 
            data[i][2] = d;
            data[i][3] = e.getHours(); 
            data[i][4] = dm;
        }
        dataModel = new DefaultTableModel(data, new String [] {"", "Name", "Date", "Hours", "Date Modified"})
        {
            Class[] types = new Class [] {Boolean.class, String.class, Calendar.class, Integer.class, Calendar.class};
            boolean[] canEdit = new boolean [] {true, false, true, true, false};

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        dataModel.addTableModelListener(this); 
        entryTable.setModel(dataModel); 
        entryTable.setAutoCreateRowSorter(true);
        
        CalendarRenderer dateFormat = new CalendarRenderer();
        DefaultTableCellRenderer center = new DefaultTableCellRenderer(); 
        center.setHorizontalAlignment(JLabel.CENTER); 
        
        TableColumn column; 
        for (int i = 0; i < 5; i++) { 
            column = entryTable.getColumnModel().getColumn(i);
            if (i == 0) { 
                column.setPreferredWidth(5);
            }
            else if(i == 3){ 
                column.setPreferredWidth(10);
                column.setCellRenderer(center); 
            }
            else if(i == 1){
                column.setCellRenderer(center);
            }
            else{ 
                column.setCellRenderer(dateFormat); 
            } 
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new JPanel();
        startPanel = new JPanel();
        newButton = new JButton();
        viewButton = new JButton();
        greetingLabel = new JLabel();
        viewEditPanel = new JPanel();
        entryTableHeader = new JScrollPane();
        entryTable = new JTable();
        tableBackButton = new JButton();
        deleteButton = new JButton();
        newUserPanel = new JPanel();
        firstNameLabel = new JLabel();
        lastNameLabel = new JLabel();
        passwordLabel = new JLabel();
        confirmLabel = new JLabel();
        submitButton = new JButton();
        newBackButton = new JButton();
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        passwordField = new JPasswordField(){
            public void paste(){}
        };
        passwordConfirmField = new JPasswordField(){
            public void paste(){}
        };

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        mainPanel.setLayout(new java.awt.CardLayout());

        startPanel.setPreferredSize(new java.awt.Dimension(338, 180));

        newButton.setActionCommand("Add New Account");
        newButton.setLabel("Add New Account");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        viewButton.setText("View/Edit Hours");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        greetingLabel.setText("Hello. What would you like to do?");

        GroupLayout startPanelLayout = new GroupLayout(startPanel);
        startPanel.setLayout(startPanelLayout);
        startPanelLayout.setHorizontalGroup(
            startPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(startPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewButton)
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, startPanelLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(greetingLabel)
                .addGap(88, 88, 88))
        );
        startPanelLayout.setVerticalGroup(
            startPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, startPanelLayout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(greetingLabel)
                .addGap(55, 55, 55)
                .addGroup(startPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(newButton)
                    .addComponent(viewButton))
                .addContainerGap())
        );

        mainPanel.add(startPanel, "startPanel");

        viewEditPanel.setPreferredSize(new java.awt.Dimension(338, 180));

        entryTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Hours", "Date Modified"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        entryTable.getTableHeader().setReorderingAllowed(false);
        entryTableHeader.setViewportView(entryTable);
        if (entryTable.getColumnModel().getColumnCount() > 0) {
            entryTable.getColumnModel().getColumn(0).setHeaderValue("Date");
            entryTable.getColumnModel().getColumn(1).setHeaderValue("Hours");
            entryTable.getColumnModel().getColumn(2).setHeaderValue("Date Modified");
        }

        tableBackButton.setText("Back");
        tableBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                tableBackButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete Selected");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        GroupLayout viewEditPanelLayout = new GroupLayout(viewEditPanel);
        viewEditPanel.setLayout(viewEditPanelLayout);
        viewEditPanelLayout.setHorizontalGroup(
            viewEditPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(entryTableHeader, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
            .addGroup(viewEditPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableBackButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteButton)
                .addContainerGap())
        );
        viewEditPanelLayout.setVerticalGroup(
            viewEditPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(viewEditPanelLayout.createSequentialGroup()
                .addComponent(entryTableHeader, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(viewEditPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tableBackButton)
                    .addComponent(deleteButton))
                .addContainerGap())
        );

        mainPanel.add(viewEditPanel, "viewEditPanel");

        newUserPanel.setPreferredSize(new java.awt.Dimension(338, 180));

        firstNameLabel.setText("Preferred First Name:");

        lastNameLabel.setText("Last Name:");

        passwordLabel.setText("Password:");

        confirmLabel.setText("Confirm Password:");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        newBackButton.setText("Back");
        newBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newBackButtonActionPerformed(evt);
            }
        });

        GroupLayout newUserPanelLayout = new GroupLayout(newUserPanel);
        newUserPanel.setLayout(newUserPanelLayout);
        newUserPanelLayout.setHorizontalGroup(
            newUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(newUserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(newUserPanelLayout.createSequentialGroup()
                        .addComponent(newBackButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitButton))
                    .addGroup(GroupLayout.Alignment.TRAILING, newUserPanelLayout.createSequentialGroup()
                        .addGroup(newUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameLabel)
                            .addComponent(lastNameLabel))
                        .addGap(78, 78, 78)
                        .addGroup(newUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameField, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(lastNameField)))
                    .addGroup(GroupLayout.Alignment.TRAILING, newUserPanelLayout.createSequentialGroup()
                        .addGroup(newUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(passwordLabel)
                            .addComponent(confirmLabel))
                        .addGap(92, 92, 92)
                        .addGroup(newUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField)
                            .addComponent(passwordConfirmField))))
                .addContainerGap())
        );
        newUserPanelLayout.setVerticalGroup(
            newUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(newUserPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(newUserPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(newUserPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(newUserPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(newUserPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmLabel)
                    .addComponent(passwordConfirmField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(newUserPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(newBackButton)
                    .addComponent(submitButton))
                .addContainerGap())
        );

        mainPanel.add(newUserPanel, "newUserPanel");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("mainFrame");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        ((CardLayout)(mainPanel.getLayout())).show(mainPanel, "newUserPanel");
    }//GEN-LAST:event_newButtonActionPerformed

    private void viewButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        for(int i = dataModel.getRowCount(); i > 0; i--){
            dataModel.setValueAt(false, i - 1, 0);
        }
        entryTable.clearSelection();
        ((CardLayout)(mainPanel.getLayout())).show(mainPanel, "viewEditPanel");
    }//GEN-LAST:event_viewButtonActionPerformed

    private void tableBackButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_tableBackButtonActionPerformed
        ((CardLayout)(mainPanel.getLayout())).show(mainPanel, "startPanel");
    }//GEN-LAST:event_tableBackButtonActionPerformed
    
    @Override
    public void tableChanged(TableModelEvent e){
        String name = (String) dataModel.getValueAt(e.getFirstRow(), 1);
        int offset = 0;
        for(Account a : Run.getAccountList()){
            if(name.equals(a.getAccountName().replace("+", " "))){
                account = a;
                break;
            }
            else{
                offset += a.getEntries().size();
            }
        }
        if(e.getColumn() == 2){
            String newDate = (String) dataModel.getValueAt(e.getFirstRow(), 2);
            if(parseDate(newDate)){
                Calendar date = new GregorianCalendar();
                String[] datePieces = newDate.split("/"); //Split the date into 3 pieces.
                if(datePieces[2].length() == 2){ //shorthand date form
                    datePieces[2] = ("" + date.get(Calendar.YEAR)).substring(0, 2) + datePieces[2]; //Getting the first two digits of the year. This method ensures working code after 2100
                }

                date.set(Integer.parseInt(datePieces[2]), Integer.parseInt(datePieces[0]) - 1, Integer.parseInt(datePieces[1]));
                account.getEntries().get(e.getFirstRow() - offset).setDate(date);
                
                dataModel.removeTableModelListener(this); //avoiding recursive fireTableStateChanged by deregistering the listener before editing cell value
                dataModel.setValueAt((date.get(Calendar.MONTH) + 1 + "/" + date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.YEAR))), e.getFirstRow(), 2);
                dataModel.addTableModelListener(this); //Strangely, none of the other setValueAt calls seem to have this issue.
            }
            else{
                Calendar oldDate = account.getEntries().get(e.getFirstRow() - offset).getDate();
                dataModel.setValueAt((oldDate.get(Calendar.MONTH) + 1 + "/" + oldDate.get(Calendar.DAY_OF_MONTH) + "/" + (oldDate.get(Calendar.YEAR))), e.getFirstRow(), 2);
            }
        }
        else if (e.getColumn() == 3){
            int hours = (int) dataModel.getValueAt(e.getFirstRow(), 3);
            if(hours > 0 && hours < 13){
                account.getEntries().get(e.getFirstRow() - offset).setHours(hours);
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Hour value is not in accepted range (1 - 12)", "Error", JOptionPane.ERROR_MESSAGE);
                dataModel.setValueAt(account.getEntries().get(e.getFirstRow() - offset).getHours(), e.getFirstRow(), 3);//TODO fix
            }
        }
    }
    
    private boolean parseDate(String s){
        Pattern datePattern = Pattern.compile("^\\d{1,2}/\\d{1,2}/(\\d\\d){1,2}$");
        if(s.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please enter a date.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(!datePattern.matcher(s).find()){ //TODO convert date
            JOptionPane.showMessageDialog(rootPane, "Please enter a date in the format MM/DD/YYYY.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            Calendar date = new GregorianCalendar();
            boolean acceptable = true; //(acceptable)
            String reason = ""; //Reason for rejection
            final String DNE = "That date does not exist.";
            String[] datePieces = s.split("/"); //Split the date into 3 pieces.
            if(datePieces[2].length() == 2){ //shorthand date form
                datePieces[2] = ("" + date.get(Calendar.YEAR)).substring(0, 2) + datePieces[2]; //Getting the first two digits of the year. This method ensures working code after 2100
            }
            int[] dateNumbers = new int[3];
            for(int i = 0; i < 3; i++){
                dateNumbers[i] = Integer.parseInt(datePieces[i]); //Store the integer values
                if(dateNumbers[i] < 0){ //If they have negative pieces
                    acceptable = false; //UNACCEPTABLE
                    reason = "You cannot have negative numbers in the date.";
                }
            }
            if(Math.abs(dateNumbers[2] - date.get(Calendar.YEAR)) > 1){ //Dates that are < +- 1 year from the current date
                acceptable = false; //UNACCEPTABLE
                reason = "That date is out of the accepted range (1 year).";
            }
            if(dateNumbers[1] > 31){ //Months with more than 31 days
               acceptable = false; //UNACCEPTABLE 
               reason = DNE;
            }
            else if(dateNumbers[0] % 2 == 1 && dateNumbers[1] > 30){ //Short months with more than 30 days
                acceptable = false; //UNACCEPTABLE
                reason = DNE;
            }
            else if(dateNumbers[0] == 2 && dateNumbers[1] > 29){ //February with more than 29 days
                acceptable = false; //UNACCEPTABLE
                reason = DNE;
            }
            else if(dateNumbers[0] == 2 && dateNumbers[1] == 29){ //It's February 29. Leap year detection.
                if(dateNumbers[2] % 4 != 0){ //Year is not divisible by 4; not a leap year
                    acceptable = false; //UNACCEPTABLE
                    reason = DNE;
                }
                else if(dateNumbers[2] % 100 != 0){ //Year is not divisible by 100 (every 100 years, the leap year is skipped)
                    acceptable = true; //(acceptable)
                }
                else if(dateNumbers[2] % 400 != 0){ //Year is not divisible by 400 (Of course, the skipping gets skipped every 400 years)
                    acceptable = false; //UNACCEPTABLE
                    reason = DNE;
                }
                else{ //No reason to think it's not a leap year.
                    acceptable = true; //(acceptable)
                }
            }
            if(acceptable){
                date.set(Integer.parseInt(datePieces[2]), Integer.parseInt(datePieces[0]) - 1, Integer.parseInt(datePieces[1]));
                if(Calendar.getInstance().compareTo(date) < 0){ //Trying to enter dates in the future
                    JOptionPane.showMessageDialog(rootPane, "You cannot enter dates in the future.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                else{
                    return true;
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, reason + "\nPlease enter a valid date.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }
    
    private void deleteButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        boolean delete = false, itemsToDelete = false;
        String message = "Are you sure you want to delete the selected entries?\nThis cannot be undone!";
        
        for(int i = dataModel.getRowCount() - 1; i > -1; i--){
            if((boolean)dataModel.getValueAt(i, 0)){
                if(!itemsToDelete){
                    delete = (JOptionPane.showConfirmDialog(rootPane, message, "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)) == 0;
                    itemsToDelete = true;
                }
                if(delete){
                    String name = (String) dataModel.getValueAt(i, 1);
                    int offset = 0;
                    for(Account a : Run.getAccountList()){
                      if(name.equals(a.getAccountName().replace("+", " "))){
                         account = a;
                         break;
                       }
                      else{
                          offset += a.getEntries().size();
                      }
                   }
                    account.getEntries().remove(i - offset);
                    dataModel.removeRow(i);
                }
                else{
                    dataModel.setValueAt(false, i, 0);
                }
            }
        }
        if(!itemsToDelete){
            JOptionPane.showMessageDialog(rootPane, "There are no entries selected.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            ImportExport.exportAll();
        }
        entryTable.clearSelection();
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void submitButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        firstNameField.setBorder(defaultBorder);
        lastNameField.setBorder(defaultBorder);
        passwordField.setBorder(defaultBorder);
        passwordConfirmField.setBorder(defaultBorder);
        
        if(firstNameField.getText().equals("")){
            firstNameField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
        if(lastNameField.getText().equals("")){
            lastNameField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
        if(Arrays.equals(passwordField.getPassword(), new char[0])){
            passwordField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
        if(Arrays.equals(passwordConfirmField.getPassword(), new char[0])){
            passwordConfirmField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
        Pattern nonAlpha = Pattern.compile("[^A-Za-z]");
        boolean nameViolation = false;
        String message = null;
        if(firstNameField.getText().equals("")){
            nameViolation = true;
            message = "Please enter a name.";
            firstNameField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));   
        }
        if(lastNameField.getText().equals("")){
            nameViolation = true;
            message = "Please enter a name.";
            lastNameField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
        if(nonAlpha.matcher(firstNameField.getText()).find()){
            nameViolation = true;
            message = "Sorry, only letters A-z are allowed for the name.";
            firstNameField.setText("");
            firstNameField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
        if(nonAlpha.matcher(lastNameField.getText()).find()){
            nameViolation = true;
            message = "Sorry, only letters A-z are allowed for the name.";
            lastNameField.setText("");
            lastNameField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
        if(nameViolation){
            JOptionPane.showMessageDialog(rootPane, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(passwordField.getPassword().length < 8){
            JOptionPane.showMessageDialog(rootPane, "Sorry, passwords must be at least 8 characters in length.", "Error", JOptionPane.ERROR_MESSAGE);
            passwordField.setText("");
            passwordField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            passwordConfirmField.setText("");
        }
        else if(!Arrays.equals(passwordField.getPassword(), passwordConfirmField.getPassword())){
            JOptionPane.showMessageDialog(rootPane, "Sorry, your passwords don't match.", "Error", JOptionPane.ERROR_MESSAGE);
            passwordField.setText("");
            passwordField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            passwordConfirmField.setText("");
            passwordConfirmField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
        else{
            byte[] username = (firstNameField.getText() + "+" + lastNameField.getText()).getBytes();
            byte[] password = Encryptor.charToByte(passwordField.getPassword()); //Get Credential's components from login screen's username/password fields.
            passwordField.setText(null); //Clearing the password field.

            byte[] credentials = new byte[username.length + password.length]; //Creating a combined credential array that is the length of username + password
            System.arraycopy(username, 0, credentials, 0, username.length); //Copying from username at 0 to credentials at 0 for all bytes in username.
            System.arraycopy(password, 0, credentials, username.length, password.length); //Copying from password at 0 to credentials at end of username for all bytes in password.
            
            Arrays.fill(username, (byte)0); //Clear username
            Arrays.fill(password, (byte)0); //Clear password
            byte[] hashedCredentials = Encryptor.hash(credentials, 1024); //Hashes the byte representation of credentials using static salt and 1024 iterations.
            Encryptor.makeKey(hashedCredentials);
            Run.addNewAccount(new Account(firstNameField.getText(), lastNameField.getText(), hashedCredentials));
            Arrays.fill(credentials, (byte)0); //Clear credentials
            JOptionPane.showMessageDialog(rootPane, "New account created successfully!\nYour username for login is: " + firstNameField.getText() + " " + lastNameField.getText(), "Success!", JOptionPane.INFORMATION_MESSAGE);
            newBackButtonActionPerformed(null);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void newBackButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_newBackButtonActionPerformed
        firstNameField.setText("");
        lastNameField.setText("");
        passwordField.setText("");
        passwordConfirmField.setText("");
        firstNameField.setBorder(defaultBorder);
        lastNameField.setBorder(defaultBorder);
        passwordField.setBorder(defaultBorder);
        passwordConfirmField.setBorder(defaultBorder);
        ((CardLayout)(mainPanel.getLayout())).show(mainPanel, "startPanel");
    }//GEN-LAST:event_newBackButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel confirmLabel;
    private JButton deleteButton;
    private JTable entryTable;
    private JScrollPane entryTableHeader;
    private JTextField firstNameField;
    private JLabel firstNameLabel;
    private JLabel greetingLabel;
    private JTextField lastNameField;
    private JLabel lastNameLabel;
    private JPanel mainPanel;
    private JButton newBackButton;
    private JButton newButton;
    private JPanel newUserPanel;
    private JPasswordField passwordConfirmField;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JPanel startPanel;
    private JButton submitButton;
    private JButton tableBackButton;
    private JButton viewButton;
    private JPanel viewEditPanel;
    // End of variables declaration//GEN-END:variables
}

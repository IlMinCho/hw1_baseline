import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    

    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      
      // Get transaction data from view
      double amount = view.getAmountField(); 
      String category = view.getCategoryField();

      // Create transaction object
      Transaction t = new Transaction(amount, category);

      // Call controller to add transaction
      view.addTransaction(t);
    });

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {

    // Get transaction data from view
    double amount = view.getAmountField(); 
    String category = view.getCategoryField();

    // Input validations
    if (!InputValidation.isValidAmount(amount)) {
        // Inform user about invalid amount and return
        JOptionPane.showMessageDialog(null, "Please enter a valid amount greater than 0 and less than 1000!");
        return;
    }
    
    if (!InputValidation.isValidCategory(category)) {
        // Inform user about invalid category and return
        JOptionPane.showMessageDialog(null, "Please enter a valid category food, travel, bills, entertainment, other!");
        return;
    }

    // Create transaction object
    Transaction t = new Transaction(amount, category);

    // Call controller to add transaction
    view.addTransaction(t);
    });


  }

}
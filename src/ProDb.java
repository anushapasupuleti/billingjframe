import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jgoodies.common.base.Strings;
import java.awt.SystemColor;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ProDb extends JFrame {
	

	private static final String search_button = null;
	private JPanel contentPane;
	private JTextField tpname;
	private JTextField tpcode;
	private JTextField tprice;
	private JTextField protsearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProSearch frame = new ProSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public  ProDb() {
		setEnabled(false);
		setBackground(SystemColor.textText);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 336);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(27, 37, 420, 252);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblProduct = new JLabel("product");
		lblProduct.setBounds(12, 36, 69, 14);
		panel.add(lblProduct);
		//protext.setText("search_button");
       // protext.getText("search_buttton");	
		JButton search_button_1 = new JButton("Search");
		search_button_1.setBounds(296, 32, 69, 23);
		search_button_1.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				System.out.print("Hello");
			
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection(  
							"jdbc:oracle:thin:@localhost:1521:orcl","system","Adminadmin20"); 

          // PreparedStatement st = con.prepareStatement("SELECT  * from product WHERE PRODUCTNAME LIKE '%'"+searchProduct.getText() +" % OR productcode LIKE % "+searchProduct.getText()+"");
						String searchName =protsearch.getText();
						
			           PreparedStatement st = con.prepareStatement("select * FROM product where PRODUCTNAME ='"+ searchName+"'");
			           
					
					
					//List<Strings> productsNames =new LinkedList<Strings>();
					ResultSet rs=st.executeQuery();  
					while(rs.next()){ 
						tpname.setText(rs.getString(1));
						tpcode.setText(rs.getString(2));
						tprice.setText(rs.getString(1));
						
						System.out.println(rs.getString(1)); 
						System.out.println(rs.getString(2)); 
						System.out.println(rs.getString(3)); 
						
					}  
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
								 
			// search product here
			
			
		}
		});
		
		//jlabel.lbltext=new jLabel("lbltext");
		panel.add(search_button_1);
		
		JLabel lblProductname = new JLabel("productname");
		lblProductname.setBounds(10, 108, 83, 14);
		panel.add(lblProductname);
		
		tpname = new JTextField();
		tpname.setBounds(143, 105, 138, 20);
		panel.add(tpname);
		tpname.setColumns(10);
		
		JLabel lblProduct_1 = new JLabel("product  code");
		lblProduct_1.setBounds(12, 161, 95, 14);
		panel.add(lblProduct_1);
		
		tpcode = new JTextField();
		tpcode.setBounds(143, 158, 138, 20);
		panel.add(tpcode);
		tpcode.setColumns(10);
		
		
		// introduction to git
		JLabel lblPrice = new JLabel("price");
		lblPrice.setBounds(10, 212, 46, 14);
		panel.add(lblPrice);
		
		tprice = new JTextField();
		tprice.setBounds(143, 209, 138, 20);
		panel.add(tprice);
		tprice.setColumns(10);
		
		protsearch = new JTextField();
		protsearch.setBounds(145, 32, 125, 23);
		panel.add(protsearch);
		protsearch.setColumns(10);
		
		JLabel lblInvoiceNumber = new JLabel("invoice number");
		lblInvoiceNumber.setBounds(296, 108, 72, 14);
		panel.add(lblInvoiceNumber);
		
		JLabel label = new JLabel("");
		label.setBounds(412, 108, 46, 14);
		panel.add(label);
		
		//search_button.setText(prosrch);
	}
}

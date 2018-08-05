import java.awt.EventQueue;
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

public class ProSearch extends JFrame {

	private static final String search_button = null;
	private JPanel contentPane;
	private JTextField searchProduct;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField protext;

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
	public ProSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 390, 240);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblProduct = new JLabel("product");
		lblProduct.setBounds(30, 32, 46, 14);
		panel.add(lblProduct);
		protext.setText("search_button");
         	
		JButton search_button = new JButton("");
		search_button.setBounds(296, 32, 69, 23);
		search_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection(  
							"jdbc:oracle:thin:@localhost:1521:orcl","system","Adminadmin20"); 

           PreparedStatement st = con.prepareStatement("SELECT  * from product WHERE PRODUCTNAME LIKE '%'"+searchProduct.getText() +" % OR productcode LIKE % "+searchProduct.getText()+"");

					//PreparedStatement stmt=con.prepareStatement("select * from product"); 
					
					//List<Strings> productsNames =new LinkedList<Strings>();
					ResultSet rs=st.executeQuery();  
					while(rs.next()){ 
						
						String str =rs.getString("Product");
						
						//productsNames.add(str);
				 
					}  
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
								 
			// search product here
			
			
		}
		});
		panel.add(search_button);
		
		JLabel lblProductname = new JLabel("productname");
		lblProductname.setBounds(30, 108, 81, 14);
		panel.add(lblProductname);
		
		searchProduct = new JTextField();
		searchProduct.setBounds(143, 105, 138, 20);
		panel.add(searchProduct);
		searchProduct.setColumns(10);
		
		JLabel lblProduct_1 = new JLabel("product  code");
		lblProduct_1.setBounds(30, 161, 93, 14);
		panel.add(lblProduct_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 158, 138, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setBounds(30, 203, 46, 14);
		panel.add(lblPrice);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 209, 138, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		protext = new JTextField();
		protext.setBounds(145, 32, 125, 23);
		panel.add(protext);
		protext.setColumns(10);
		
		//search_button.setText(prosrch);
	}
}

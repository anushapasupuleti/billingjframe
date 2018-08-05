import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class reg extends JFrame {

	private JPanel contentPane;
	private JTextField proname;
	private JTextField productname;
	private JTextField procode;
	private JTextField proprice;
	private JTextField cmane;
	private JTextField cnum;
	private JTextField cpro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reg frame = new reg();
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
	public reg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 24, 804, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.setBounds(336, 11, 156, 22);
		dateChooser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				 try{
					  Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection(  
								"jdbc:oracle:thin:@localhost:1521:orcl","system","Adminadmin20"); 
				     PreparedStatement pst =  (PreparedStatement) con.createStatement();
				        ResultSet rs = pst.executeQuery("select * from invoicesheet");

				        while(rs.next()){
				       
				       rs.getString("invoice_number");
				        							rs.getString("invoicedate");
				                           }
				        con.close();
				  }
				        catch(Exception ex){
				        System.out.println(ex);
				         }
				        
			}
		});
		panel.add(dateChooser);
		/*dateChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		  try{
			  Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:orcl","system","Adminadmin20"); 
		     PreparedStatement pst =  (PreparedStatement) con.createStatement();
		        ResultSet rs = pst.executeQuery("select * from invoicesheet");

		        while(rs.next()){
		       
		       rs.getString("invoice_number");
		        							rs.getString("invoicedate");
		                           }
		        con.close();
		  }
		        catch(Exception ex){
		        System.out.println(ex);
		         }
		        
		  }
			});*/
		
		Panel pname = new Panel();
		pname.setBounds(10, 78, 825, 373);
		contentPane.add(pname);
		pname.setLayout(null);
		
		JLabel prd = new JLabel("PRODUCT ");
		prd.setBounds(10, 28, 109, 14);
		pname.add(prd);
		
		proname = new JTextField();
		proname.setBounds(129, 25, 118, 20);
		pname.add(proname);
		proname.setColumns(10);
		
		Button srch = new Button("search");
		srch.setBounds(268, 28, 84, 14);
		srch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:orcl","system","Adminadmin20"); 
				
			
				Statement smt=con.prepareStatement("select * from PRODUCT where PRODUCT=?");
				ResultSet rs=smt.executeQuery("select * from PRODUCT where PRODUCT=?"); 
				while (rs.next()) {
					
				    String productname= rs.getString("PRODUCTNAME");
				    String productcode = rs.getString("PRODUCTCODE");
				    String price = rs.getString("PRICE");
				   
				}
				
			con.close();		  
				}	
			catch(Exception h)
			{ 
				System.out.println(h);
				
			}
			}
		});
		
		/*dateChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		  try{
			  Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:orcl","system","Adminadmin20"); 
		     PreparedStatement pst =  (PreparedStatement) con.createStatement();
		        ResultSet rs = pst.executeQuery("select * from invoicesheet");

		        while(rs.next()){
		       
		       rs.getString("invoice_number");
		        							rs.getString("invoicedate");
		                           }
		        con.close();
		  }
		        catch(Exception ex){
		        System.out.println(ex);
		         }
		        
		  }
			});*/
		pname.add(srch);
		
		JLabel lblPrice = new JLabel("PRODUCT NAME");
		lblPrice.setBounds(10, 84, 84, 14);
		pname.add(lblPrice);
		
		productname = new JTextField();
		productname.setBounds(129, 81, 118, 20);
		pname.add(productname);
		productname.setColumns(10);
		
		
		
		JLabel lblProductCode = new JLabel("PRODUCT CODE");
		lblProductCode.setBounds(291, 77, 84, 29);
		pname.add(lblProductCode);
		
		procode = new JTextField();
		procode.setBounds(389, 81, 118, 20);
		pname.add(procode);
		procode.setColumns(10);
		
		JLabel lblPrice_1 = new JLabel("PRICE");
		lblPrice_1.setBounds(549, 84, 84, 14);
		pname.add(lblPrice_1);
		
		proprice = new JTextField();
		proprice.setBounds(617, 81, 118, 20);
		pname.add(proprice);
		proprice.setColumns(10);
		
		JLabel lblCustomername = new JLabel("CUSTOMERNAME");
		lblCustomername.setBounds(10, 149, 95, 14);
		pname.add(lblCustomername);
		
		cmane = new JTextField();
		cmane.setBounds(129, 146, 118, 20);
		pname.add(cmane);
		cmane.setColumns(10);
		
		JLabel lblCustomerNumber = new JLabel("CUSTOMER NUMBER");
		lblCustomerNumber.setBounds(291, 149, 109, 14);
		pname.add(lblCustomerNumber);
		
		cnum = new JTextField();
		cnum.setBounds(396, 146, 111, 20);
		pname.add(cnum);
		cnum.setColumns(10);
		
		JLabel lblOrderProduct = new JLabel("ORDER PRODUCT");
		lblOrderProduct.setBounds(551, 149, 129, 14);
		pname.add(lblOrderProduct);
		
		cpro = new JTextField();
		cpro.setBounds(649, 146, 109, 20);
		pname.add(cpro);
		cpro.setColumns(10);
		
	}
}

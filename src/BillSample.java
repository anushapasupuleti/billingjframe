import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;
import java.util.Random;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BillSample extends JFrame {

	private JPanel contentPane;
	private JTextField inv_no;
	private JTextField cus_name;
	private JTextField cus_mob;
	private JTextField prod_code;
	private JTextField amount;
	private JTextField quantity;
	private JTextField gst;
	private JTextField totalorder;
	private JTable table;
	private JTextField bill_no;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillSample frame = new BillSample();
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
	public BillSample() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 754);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 650, 127);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIbotricsBillingQuotation = new JLabel("IBOTRICS BILLING QUOTATION");
		lblIbotricsBillingQuotation.setBounds(190, 5, 217, 17);
		lblIbotricsBillingQuotation.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(lblIbotricsBillingQuotation);
		
		JLabel label = new JLabel("");
	label.setBounds(10, 7, 102, 96);
		label.setIcon(new ImageIcon("C:\\Users\\iBotrics\\Desktop\\IBOTRICS IMAGE\\2.png"));
		panel.add(label);
		
		JLabel lblDrNo = new JLabel("Dr No:34-4-53,Congress Office Road,Vijayawada-529108");
		lblDrNo.setBounds(171, 33, 314, 32);
		panel.add(lblDrNo);
		
		JLabel lblGstIn = new JLabel("    GST IN:37BIVPN5224M");
		lblGstIn.setBounds(122, 76, 169, 40);
		panel.add(lblGstIn);
		
		JLabel lblMobile = new JLabel("Mobile:9848022338");
		lblMobile.setBounds(401, 80, 126, 32);
		panel.add(lblMobile);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 138, 754, 380);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 744, 404);
		panel_1.add(panel_2);
		
		inv_no = new JTextField();
		inv_no.setBounds(150, 89, 141, 20);
		Random rn = new Random();

		for(int i =0; i < 100; i++)
		{
		    int inv_no = rn.nextInt(10) + 1;
		    System.out.println(inv_no);
		}
		panel_2.setLayout(null);
		panel_2.add(inv_no);
		inv_no.setColumns(10);
		
		
		JLabel lblInvoiceNo = new JLabel("INVOICE NO:");
		lblInvoiceNo.setBounds(9, 86, 109, 26);
		
		
		panel_2.add(lblInvoiceNo);
		
		JLabel lblInvoiceDate = new JLabel("INVOICE DATE:");
		lblInvoiceDate.setBounds(422, 92, 101, 14);
		
		panel_2.add(lblInvoiceDate);

		
		JLabel lblCustomername = new JLabel("  CUSTOMER  NAME:");
		lblCustomername.setBounds(9, 153, 118, 20);
		panel_2.add(lblCustomername);
		
		cus_name = new JTextField();
		cus_name.setBounds(150, 142, 200, 31);
		panel_2.add(cus_name);
		cus_name.setColumns(10);
		
		JLabel lblCustomerMobile = new JLabel("CUSTOMER MOBILE:");
		lblCustomerMobile.setBounds(422, 156, 128, 14);
		panel_2.add(lblCustomerMobile);
		
		cus_mob = new JTextField();
		cus_mob.setBounds(555, 142, 156, 31);
		panel_2.add(cus_mob);
		cus_mob.setColumns(10);
		
		JLabel lblProductId = new JLabel("PRODUCT ID:");
		lblProductId.setBounds(9, 203, 101, 31);
		panel_2.add(lblProductId);
		
		JComboBox productname = new JComboBox();
		productname.setBounds(150, 208, 100, 20);
		productname.addItem("");
		productname.addItem("laptop");
		productname.addItem("keyboard");
		productname.addItem("mouse");
		productname.addItem("harddisk");
		productname.addItem("mother board");
		productname.addItem("processor");
		panel_2.add(productname);
		
		JLabel lblNewLabel = new JLabel("PRODUCT CODE:");
		lblNewLabel.setBounds(422, 208, 111, 20);
		panel_2.add(lblNewLabel);
		
		prod_code = new JTextField();
		prod_code.setBounds(560, 208, 118, 20);
		panel_2.add(prod_code);
		prod_code.setColumns(10);
		
		JLabel lblAmount = new JLabel("AMOUNT");
		lblAmount.setBounds(9, 263, 62, 31);
		panel_2.add(lblAmount);
		
		amount = new JTextField();
		amount.setBounds(150, 268, 100, 20);
		panel_2.add(amount);
		amount.setColumns(10);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setBounds(422, 271, 72, 14);
		panel_2.add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setBounds(560, 268, 109, 20);
		panel_2.add(quantity);
		quantity.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("GST:");
		lblNewLabel_1.setBounds(9, 315, 62, 31);
		panel_2.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(105, 275, 46, 14);
		panel_2.add(label_1);
		
		gst = new JTextField();
		gst.setBounds(150, 326, 86, 20);
		gst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			    
			      
			    String x= amount.getText();
				 int a= Integer.parseInt(x);
				
				 
				 String y=(String)quantity.getText();
				 int b= Integer.parseInt(y);
				 
				 
				 String w= gst.getText();
				int g=Integer.parseInt(w);
				
				  int k= a*g/(g+100);
				
		         int r= k +a;
		         
		         int t =r * b;
				 
				 String z=Integer.toString(t);
				 totalorder.setText(z);
			     
			     
			     
			
			}
			
		});
		gst.setText("18");
		panel_2.add(gst);
		gst.setColumns(10);
		
		
		JLabel lblTotalAmount = new JLabel("TOTAL AMOUNT");
		lblTotalAmount.setBounds(422, 323, 86, 14);
		panel_2.add(lblTotalAmount);
		
		
		//introduction to git
		totalorder = new JTextField();
		totalorder.setBounds(560, 326, 113, 20);
		panel_2.add(totalorder);
		totalorder.setColumns(10);
		
		Panel panel_3 = new Panel();
		panel_3.setBounds(28, 52, 575, -49);
		panel_2.add(panel_3);
		
		Panel panel_4 = new Panel();
		panel_4.setBounds(343, 10, 353, 55);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JRadioButton reg = new JRadioButton("REGULAR");
		reg.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent arg0) {
			}
		});
		reg.setBounds(6, 7, 109, 23);
		panel_4.add(reg);
		
		JRadioButton est = new JRadioButton("ESTIMATION");
		est.setBounds(140, 7, 109, 23);
		panel_4.add(est);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(reg);
		bg.add(est);
		reg.setSelected(true);
		
		JDateChooser OrderDate = new JDateChooser();
		OrderDate.setBounds(555, 89, 141, 20);
		OrderDate.setDateFormatString("dd MM yyyy");
		
		panel_2.add(OrderDate);
		
		JLabel lblBillno = new JLabel("BILLNO");
		lblBillno.setBounds(28, 22, 46, 14);
		panel_2.add(lblBillno);
		
		bill_no = new JTextField();
		bill_no.setBounds(150, 19, 118, 20);
		panel_2.add(bill_no);
		bill_no.setColumns(10);
		this.setVisible(true);
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(258, 529, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try {
						   Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection con=DriverManager.getConnection(  
									"jdbc:oracle:thin:@localhost:1521:orcl","system","Adminadmin20"); 
							//Statement smt=con.createStatement();
							    String insertData=("insert into  SYSTEM.BILLPAY values(?,?,?,?,?,?,?,?,?,?)");
								PreparedStatement ps= con.prepareStatement(insertData);
								ps.setString(1, inv_no.getText());
							    ps.setString(2, ((JTextField)OrderDate.getDateEditor().getUiComponent()).getText());
								//ps.setString(2, dateChooser.getDateFormatString());
								ps.setString(3, cus_name.getText());
								ps.setString(4, cus_mob.getText());
								ps.setString(5, productname.getSelectedItem().toString());
								 ps.setString(6,prod_code.getText());
								ps.setString(7, amount.getText());
								ps.setString(8,quantity.getText());
								ps.setString(9, gst.getText());
		                        ps.setString(10,totalorder.getText());
		                     
								int inserted =ps.executeUpdate();
								 
								if(inserted>0) {
									
									JOptionPane.showMessageDialog(null, "Data Inserted sucessfully");
								}
				}	
							 catch(Exception e1) {
								e1.printStackTrace();
							} finally {
							
							
		                   }
		}
		});
		contentPane.add(btnSubmit);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				inv_no.setText("");
				//(JDateChooser) OrderDate).setText("");
				cus_name.setText("");
				cus_mob.setText("");
			    //productname.setText("");
				prod_code.setText("");
				quantity.setText("");
				amount.setText("");
				gst.setText("");
				totalorder.setText("");
			}
		});
		btnClear.setBounds(418, 529, 89, 23);
		contentPane.add(btnClear);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 563, 746, 145);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"inv_no", "OrderDate", "cus_name", "cus_mob", "productname", "prod_code", "quantity", "amount", "gst", "ordertotal"},
			
			
			},
			new String[] {
				"inv_no", "OrderDate", "cus_name", "cus_mob", "productname" ,"prod_code", "quantity", "amount", "gst", "ordertotal"
			}
		));
		
		
		table.setBounds(10, 11, 692, 123);
		panel_5.add(table);
		
		JButton btnDispalyText = new JButton("dispaly text");
		btnDispalyText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
						
;						model.addRow(new Object[] {
						
						
						inv_no.getText(),
						OrderDate.getDate(),
						cus_name.getText(),
						cus_mob.getText(),
						//((JTextF) comboBox).getText(),
						
					     //comboBox.getComboBox(),
						prod_code.getText(),
						
						
						quantity.getText(),
						amount.getText(),
						
						gst.getText(),
						
						//amnt.getText(),
						//disc_per.getText(),
						totalorder.getText()
					});
				}
		});
		btnDispalyText.setBounds(102, 529, 89, 23);
		contentPane.add(btnDispalyText);
		
		

	}
}

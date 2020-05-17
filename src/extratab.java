import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class extratab extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Flight> flights;
	private Calendar simtime;
	
	public extratab(ArrayList<Flight> flights, Calendar simtime) throws HeadlessException {
		this.simtime = simtime;
		this.flights = flights;
		initTimes(this.simtime);
		startFlightThreads(flights);
		permission_control.start();
		initComponents();
	}
    
	//Uçuş Threadleri başlatılır.
	public void startFlightThreads(ArrayList<Flight> flights) {
		for(Flight tmp: flights) {
			tmp.start();
		}
	}

	//Sistem saatini gösterirken kullanılacak değişkenler ilklendirilir.
    public static Calendar cal = Calendar.getInstance();
    public static Calendar exTime = Calendar.getInstance();
	public void initTimes(Calendar simtime) {
		cal.set(Calendar.HOUR_OF_DAY, simtime.get(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE, simtime.get(Calendar.MINUTE));
		cal.set(Calendar.SECOND, simtime.get(Calendar.SECOND));
		cal.set(Calendar.DAY_OF_WEEK, simtime.get(Calendar.DAY_OF_MONTH));
		
		exTime.set(Calendar.HOUR_OF_DAY, simtime.get(Calendar.HOUR_OF_DAY));
		exTime.set(Calendar.MINUTE, simtime.get(Calendar.MINUTE));
		exTime.set(Calendar.SECOND, simtime.get(Calendar.SECOND));
		exTime.set(Calendar.DAY_OF_WEEK, simtime.get(Calendar.DAY_OF_MONTH));
	}
    
	//İzin isteyen uçuş olup olmadığını kontrol eden thread.
    public Thread permission_control = new Thread( new Runnable() {
    	
    	public void run() {
    		while(true) {
    			try {
    				for(Flight tmp : flights) {
        				if(tmp.getStatus().equals("givePermission")) {
        	                permission_label.setText(tmp.getFlightNumber() + " asks for permission!");
        				}
        			}
        			try {
    					Thread.sleep(500);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
    			}catch(NullPointerException e) {
    				
    			}
    			refreshTable();
    		}
    	}
    });
	
    private void initComponents() {

        start_button = new javax.swing.JButton();
        pause_button = new javax.swing.JButton();
        stop_button = new javax.swing.JButton();
        systemtime_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        delay_textbox = new javax.swing.JTextField();
        delay_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        permission_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        flight_table = new javax.swing.JTable();
        permission_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulation");

        start_button.setText("START");
        start_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_buttonActionPerformed(evt);
            }
        });

        pause_button.setText("PAUSE");
        pause_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pause_buttonActionPerformed(evt);
            }
        });

        stop_button.setText("STOP");
        stop_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop_buttonActionPerformed(evt);
            }
        });

        systemtime_label.setText("");

        jLabel1.setText("Control Tower :");

        delay_textbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delay_textboxActionPerformed(evt);
            }
        });

        delay_button.setText("Set Delay");
        delay_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delay_buttonActionPerformed(evt);
            }
        });

        cancel_button.setText("Cancel Flight");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });

        permission_button.setText("Give Permission");
        permission_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permission_buttonActionPerformed(evt);
            }
        });

        flight_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight Number", "Name of Airlines", "Take off From", "Land to", "Taken Time", "Weekdays", "Departure", "Arrival", "State"
            }
        ) {
           
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        flight_table.getTableHeader().setReorderingAllowed(false);
        flight_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flight_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(flight_table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(delay_button, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delay_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(248, 248, 248)
                        .addComponent(permission_label, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(permission_button, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(systemtime_label, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                        .addComponent(start_button, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pause_button, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(stop_button, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stop_button, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(systemtime_label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pause_button, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(start_button, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delay_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delay_button, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(permission_button, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(permission_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                         

    private void delay_textboxActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:	
    }                                             

    private void flight_tableMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
    }                                         
    
    //Dosyadan okuyarak arayüzdeki tabloyu doldurur.
    @SuppressWarnings("unchecked")
	public void fillTable() {
    	DefaultTableModel model = (DefaultTableModel) flight_table.getModel();
    	String fileName = "src/flights.dat";
    	ObjectInputStream reader;
		try {
			reader = new ObjectInputStream(new FileInputStream(fileName));
			ArrayList<Flight> flights = (ArrayList<Flight>)reader.readObject();
	    	for(Flight tmp : flights) {
	    		
				Object addThis[] = {tmp.getFlightNumber(), tmp.getNameOfAirlines(), tmp.getTakeoffFrom().getName(), tmp.getLandTo().getName(), String.valueOf(tmp.getTakenTime().getTime()).split(" ")[3], tmp.getWeekdays(),String.valueOf(tmp.getDeparture().getTime()).split(" ")[3], String.valueOf(tmp.getArrivalTime().getTime()).split(" ")[3], tmp.getStatus()};
	    		model.addRow(addThis);
	    	}
	    	reader.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
    }
    
    //Uçuşlar üzerinde yapılan her değişiklikten sonra listeyi tekrar dosyaya yazar.
    public void writeFile(ArrayList<Flight> flights) {
    	
    	String fileName = "src/flights.dat";
    	try {
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName));
			writer.writeObject(flights);
			writer.close();
    	} catch (IOException e) {
			e.printStackTrace();
		}	
    }
    
    //Uçakların status değişimlerini tabloya yansıtmak için sürekli tabloyu günceller.
    public void refreshTable(){
    	DefaultTableModel model = (DefaultTableModel) flight_table.getModel();
		int i = 0;
		for(Flight tmp : flights) {
			try {
			model.setValueAt(tmp.getStatus(), i, 8);
			i++;
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
	   	}		
	}
    
    //Uçuş numarası verilen uçuşu var ise listeden döndürür.
    public Flight findFlight(String no) {
    	for(Flight tmp : flights) {
    		if(tmp.getFlightNumber().equals(no)) {
    			return tmp;
    		}
    	}
    	return null;
    }
    
    //Başlat butonu ile birlikte sistem zamanı başlatılır.
    public Thread clock;
    public int start_stop = 1;
    private void start_buttonActionPerformed(java.awt.event.ActionEvent evt) {                        
    	if(start_stop == 1) {
    		cal = exTime;
    		clock = new Thread( new Runnable(){
            	public void run() {
        			while(true) {
        				try {
        					cal.add(Calendar.MINUTE, 1);
        					systemtime_label.setText(String.valueOf(cal.getTime()));
        					exTime = cal;
        					Thread.sleep(1000);
        				} catch (InterruptedException e) {
        					e.printStackTrace();
        				}
        			}
        		}
            });
        	clock.start();
        	start_stop = 0;
    	}
    }                                            

    //Zamanı duraklatma butonu
    @SuppressWarnings("deprecation")
	private void pause_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(start_stop == 0) {
        	clock.stop();
        	start_stop = 1;
        }
    }                                            
    
    //Zamanı başa alma butonu
    @SuppressWarnings("deprecation")
	private void stop_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(start_stop == 0) {
        	clock.stop();
    		exTime.set(Calendar.HOUR_OF_DAY, simtime.get(Calendar.HOUR_OF_DAY));
    		exTime.set(Calendar.MINUTE, simtime.get(Calendar.MINUTE));
    		exTime.set(Calendar.SECOND, simtime.get(Calendar.SECOND));
        	start_stop = 1;
        }
    	
        
    }                                           

    //Uçuş izni isteyen uçaklara izin vermek için kullanılan buton
	private void permission_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    	DefaultTableModel model = (DefaultTableModel) flight_table.getModel();
        
        int selected_row = flight_table.getSelectedRow();
        
        if(selected_row == -1){
            if(flight_table.getRowCount() == 0){
                JOptionPane.showMessageDialog(this, "Table is empty!");
            }
            else{
                JOptionPane.showMessageDialog(this, "No selection row!");
            }
        }
        else{
            Flight tmp = findFlight((String)model.getValueAt(selected_row, 0));
            if(tmp != null && tmp.getStatus().equals("givePermission")){
            	model.setValueAt("onGround", selected_row, 8);
            	tmp.setStatus("onGround");
            	writeFile(flights);
            }        
        }
        permission_label.setText("");
    }
    
	//Uçuşu eğer yerde ise iptal eden buton.
    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        DefaultTableModel model = (DefaultTableModel) flight_table.getModel();
        int selected_row = flight_table.getSelectedRow();
        
        if(selected_row == -1){
            if(flight_table.getRowCount() == 0){
                JOptionPane.showMessageDialog(this, "Table is empty!");
            }
            else{
                JOptionPane.showMessageDialog(this, "No selection row!");
            }
        }
        else{
            Flight tmp = findFlight((String)model.getValueAt(selected_row, 0));
            if(tmp != null) {
            	if(!tmp.getStatus().equals("isFlying") && !tmp.getStatus().equals("givePermission")) {
            		model.removeRow(selected_row);
                    JOptionPane.showMessageDialog(this, "Flight cancelled successfully!");
                	flights.remove(tmp);
            	}
            	else {
            		JOptionPane.showMessageDialog(this, "Flight cannot be cancelled with this state!");
            	}        
            }
            else {
            	JOptionPane.showMessageDialog(this, "Flight cannot find!");
            }
        }
        writeFile(flights);
    }                                             

    //Uçuşa delay eklemek için kullanılan buton.
	private void delay_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                             
    	DefaultTableModel model = (DefaultTableModel) flight_table.getModel();
        
        int selected_row = flight_table.getSelectedRow();
        if(!delay_textbox.getText().equals("")) {
        	if(selected_row == -1){
                if(flight_table.getRowCount() == 0){
                    JOptionPane.showMessageDialog(this, "Table is empty!");
                }
                else{
                    JOptionPane.showMessageDialog(this, "No selection row!");
                }
            }
            else{
            	if(Flight_Track.isCorrectForm(delay_textbox.getText())) {
	                Flight tmp = findFlight((String)model.getValueAt(selected_row, 0));
	                if(tmp != null){
	
	                	Calendar tmp2 = new GregorianCalendar();
	                	tmp2.set(Calendar.HOUR_OF_DAY, Integer.parseInt(delay_textbox.getText().split(":")[0]) + tmp.getDeparture().get(Calendar.HOUR_OF_DAY));
	                	tmp2.set(Calendar.MINUTE, Integer.parseInt(delay_textbox.getText().split(":")[1]) + tmp.getDeparture().get(Calendar.MINUTE));
	                	tmp2.set(Calendar.SECOND, Integer.parseInt(delay_textbox.getText().split(":")[2]) + tmp.getDeparture().get(Calendar.SECOND));
	              	
	                   	tmp.setDeparture(tmp2);             	
	                   	model.setValueAt(String.valueOf(tmp2.getTime()).split(" ")[3], selected_row, 6);
	                   	
	                   	tmp2.set(Calendar.HOUR_OF_DAY, Integer.parseInt(delay_textbox.getText().split(":")[0]) + tmp.getArrivalTime().get(Calendar.HOUR_OF_DAY));
	                	tmp2.set(Calendar.MINUTE, Integer.parseInt(delay_textbox.getText().split(":")[1]) + tmp.getArrivalTime().get(Calendar.MINUTE));
	                	tmp2.set(Calendar.SECOND, Integer.parseInt(delay_textbox.getText().split(":")[2]) + tmp.getArrivalTime().get(Calendar.SECOND));
	                	
	                   	tmp.setArrivalTime(tmp2);             	
	                   	model.setValueAt(String.valueOf(tmp2.getTime()).split(" ")[3], selected_row, 7);
   	
	                	writeFile(flights);
	                }
            	}
            	else {
            		JOptionPane.showMessageDialog(this, "Time box is not given the right form!");
            	}
            }
            delay_textbox.setText("");
        }
    }                                            
    
    //Değişken Tanımları    
    private javax.swing.JButton cancel_button;
    private javax.swing.JButton delay_button;
    private javax.swing.JTextField delay_textbox;
    private javax.swing.JTable flight_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pause_button;
    private javax.swing.JButton permission_button;
    private javax.swing.JLabel permission_label;
    private javax.swing.JButton start_button;
    private javax.swing.JButton stop_button;
    private javax.swing.JLabel systemtime_label;                
}

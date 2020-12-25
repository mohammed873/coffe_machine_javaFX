package application;




import java.awt.List;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import com.coffeemachine.controllers.ClientController;
import com.coffeemachine.controllers.MachineController;
import com.coffeemachine.controllers.ProductController;
import com.coffeemachine.controllers.TechnicianController;
import com.coffeemachine.models.Client;
import com.coffeemachine.models.Machine;
import com.coffeemachine.models.Product;
import com.coffeemachine.models.Technician;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CoffeeMachineController implements Initializable{

	    @FXML
	    private TextField tech_name;

	    @FXML
	    private TextField tech_phone;

	    @FXML
	    private TextField tech_idRef;

	    @FXML
	    private TextField tech_successCode;
	    
	    @FXML
	    private TableView<Technician> tech_table;
	    
	    @FXML
	    private TableColumn<Technician, Long> id;

	    @FXML
	    private TableColumn<Technician, String> name;

	    @FXML
	    private TableColumn<Technician, String> phone;

	    @FXML
	    private TableColumn<Technician, String> idRF;

	    @FXML
	    private TableColumn<Technician, String> code;
	    
	    @FXML
	    private Button add_tech;
	    
	    @FXML
	    private Label message;
	    
	    
	    //declaration
	    TechnicianController tech ;
	    Technician technician;   
	    public  ObservableList<Technician> tech_list = FXCollections.observableArrayList();
	    
	  
	    // Adding data to the ObservableList (technician)
	    public void AddTechnician() throws Exception {
	    	if(tech_name.getText().isEmpty() || tech_phone.getText().isEmpty() || tech_idRef.getText().isEmpty() || tech_successCode.getText().isEmpty()) {
	    		//flash message for error
	    		message.setText("please fill all inputs");
	    	}else {
	    		//generate random id
	  		    Random rd = new Random();
	  	        long id1 = (long)(rd.nextDouble()*100000000L);
	  	        
	  	        technician =new Technician(id1,tech_name.getText(),tech_phone.getText(),tech_idRef.getText(),tech_successCode.getText());
	    		tech = new TechnicianController();
		    	tech_list.add(technician);
		    	
		    	//flash message for success
		    	message.setText("Technicien is added");
		    	
		        //clear inputs
		    	clearInputs ();
		    	
		        //loading data
		    	loadTechnicianData();
	    	}
	    } 
	    
	    
	    //Clearing data from the inputs (technician)
	 	public void clearInputs () {
	 		tech_name.clear();
	 		tech_phone.clear();
	 		tech_idRef.clear();
	 		tech_successCode.clear();
	 	}
	 	
	 	
	 	// Initialise the table view culums to match the attr of the class(technician)
	    public void initialize (URL url , ResourceBundle rb) {
	    	id.setCellValueFactory(new PropertyValueFactory<>("id"));
	    	name.setCellValueFactory(new PropertyValueFactory<>("name"));
	    	phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
	    	idRF.setCellValueFactory(new PropertyValueFactory<>("idRef"));
	    	code.setCellValueFactory(new PropertyValueFactory<>("accessCode"));
	    
	    }

        //load data from the array list (technician)
		public void loadTechnicianData() {
			tech_table.setItems(tech_list);
			initialize(null, null);
		}
	    	
		
	
		/////////////////////////////////// product section //////////////////////////////////////////
		
		
		
		 @FXML
		 private TableView<Product> product_table;

		 @FXML
		 private TableColumn<Product, Long> product_id;

		 @FXML
		 private TableColumn<Product, String> product_name;
		 
		 @FXML
		 private TableColumn<Product, Double> product_price;

		 @FXML
		 private TextField product_price1;

		 @FXML
		 private TextField prduct_name1;

		 @FXML
		 private Button add_product;
		 
		  @FXML
		    private Label message1;
		    
		   
		//declaration
		    ProductController product_cnotroller ;
		    Product product;   
		    ObservableList<Product> product_list = FXCollections.observableArrayList();
		    
		    
		// Adding data to the ObservableList (product)
		    public void AddProduct() throws Exception {
		    	if(prduct_name1.getText().isEmpty() || product_price1.getText().isEmpty()) {
		    		//flash message for error
		    		message1.setText("please fill all the inputs");
		    	}else {
		    		//generate random id
		  		    Random rd = new Random();
		  	        long id1 = (long)(rd.nextDouble()*100000000L);
		  	        
		  	        product = new Product(id1,prduct_name1.getText() ,  Double.parseDouble(product_price1.getText()) );
		  	        product_cnotroller = new ProductController();
		  	        product_list.add(product); 
		  	        
		  	        //flash message for success
		  	        message1.setText("Poduct is added ");
		  	        
		  	        //clearing inputs
		  	        clearProductInputs ();
			    	
		  	        //loading data
		  	        loadProductData();
		    		
		    	}
		    } 
	    
		    //Clearing data from the inputs (product)
		 	public void clearProductInputs () {
		 		prduct_name1.clear();
		 		product_price1.clear();
		 		
		 	}
		 		 		
		    // Initialise the table view culums to match the attr of the class(product)
			public void initialize1(URL url, ResourceBundle rb) {
				product_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		    	product_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		    	product_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		    	
			}
			
			
		    //load data from the array list (product)
			public void loadProductData() {
				product_table.setItems(product_list);
				initialize1(null, null);
			}
			
			
			
        /////////////////////////////////// machine section //////////////////////////////////////////
			
			
			 @FXML
			    private TextField machine_change;

			    @FXML
			    private Button add_machine;

			    @FXML
			    private Label message2;

			    @FXML
			    private ComboBox<?> product_list1;

			    @FXML
			    private TableView<Machine> machine_table;
			    
			    @FXML
			    private TableColumn<Machine, Long> machine_id;
			    
			    @FXML
			    private TableColumn<Machine, Boolean> isTurnedOn;

			    @FXML
			    private TableColumn<Machine, Double> sumChange;

			    @FXML
			    private TableColumn<Machine, List> products;

			  //declaration
			    MachineController machine_cnotroller ;
			    Machine machine;   
			    ObservableList<Machine> machine_list =FXCollections.observableArrayList();
			    
			    
			 // Adding data to the ObservableList (machine)
			    public void AddMachine() throws Exception {
			   
			    		//generate random id
			  		    Random rd = new Random();
			  	        long id2 = (long)(rd.nextDouble()*100000000L);
			  	        
			  	        machine_cnotroller = new MachineController();
			  	        machine = new Machine(id2);
			  	        machine_list.add(machine); 
			  	        
			  	        //flash message for success
			  	        message2.setText("Machine is added ");    
			  	       
			  	        //loading data
			  	        loadMachinetData();		
			    	
			    } 
			    
			 
			    // Initialise the table view culums to match the attr of the class(machine)
			    public void initialize2(URL url, ResourceBundle rb) {
			    	machine_id.setCellValueFactory(new PropertyValueFactory<>("id"));
					sumChange.setCellValueFactory(new PropertyValueFactory<>("sumChange"));
				}
			    
			  //load data from the array list (product)
				public void loadMachinetData() {
					machine_table.setItems(machine_list);
					initialize2(null, null);
				}
			    
				
			    
       /////////////////////////////////// client section //////////////////////////////////////////
				
				@FXML
			    private TableView<Client> client_table;

			    @FXML
			    private TableColumn<Client, Long> C_id;
			    
			    @FXML
			    private TableColumn<Client, String> C_phone;

			    @FXML
			    private TableColumn<Client, String> C_name;
			    @FXML
			    private TableColumn<Client, String> C_choice;

			    @FXML
			    private TableColumn<Client, Double> C_coins;

			    @FXML
			    private TextField client_coins;
			    
			    @FXML
			    private TextField client_name;

			    @FXML
			    private TextField client_number;
			    
			    @FXML
			    private TextField client_choice;

			    @FXML
			    private Label message3;
				
			    //declaration
			    ClientController client_cnotroller ;
			    Client  client;   
			    public ObservableList<Client>  client_list = FXCollections.observableArrayList();
			    
			 // Adding data to the ObservableList (client)
			    public void AddClient() throws Exception {
			      if(client_name.getText().isEmpty() ||client_number.getText().isEmpty()  || client_choice.getText().isEmpty()  || client_coins.getText().isEmpty() ) {
			    	  //flash message for error
			    	  message3.setText("please fill all inputs");
			      }else {
			    	//generate random id
			  		    Random rd = new Random();
			  	        long id2 = (long)(rd.nextDouble()*100000000L);
			  	       
			  	        client_cnotroller = new ClientController();
			  	        client = new Client(id2, client_name.getText(), client_number.getText(), client_choice.getText(), Double.parseDouble(client_coins.getText()));
			  	        client_list.add(client); 
			  	        
			  	        //flash message for success
			  	        message3.setText("Client is added ");   
			  	        
			  	        //recall loading function
			  	        loadClientData();
			  	        
			  	        //clearing data
			  	        clearClientInputs();
			          }
			    }  
			    
			    
			    //Clearing data from the inputs (client)
			 	public void clearClientInputs () {
			 		client_name.clear();
			 		client_number.clear();
			 		client_choice.clear();
			 		client_coins.clear();
			 		
			 	}
			    
			      // Initialise the table view culums to match the attr of the class(client)
			      public void initialize3(URL url, ResourceBundle rb) {
				    	C_id.setCellValueFactory(new PropertyValueFactory<>("id"));
				    	C_name.setCellValueFactory(new PropertyValueFactory<>("name"));
						C_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
				    	C_choice.setCellValueFactory(new PropertyValueFactory<>("choice"));
				    	C_coins.setCellValueFactory(new PropertyValueFactory<>("coins"));
					}
				    
			      
				  //load data from the array list (client)
				  public void loadClientData() {
					client_table.setItems(client_list);
					initialize3(null, null);
					
				}
				  
				  
				  
				  ////////////////////////////////////////////////////// order part /////////////////////////////////////////////////////////////////
				  
				    @FXML
				    private ComboBox<Machine> machine_select;
				    
				    @FXML
				    private ComboBox<Client> client_select;
				    
				    @FXML
				    private ComboBox<Product> product_select;
				    
				    @FXML
				    private Label macine_message;
				    
					
				    public void setMachinesChoice() {
				    	machine_select.setItems(machine_list);
				    }
				    
				    public void setClientChoice() {
				    	client_select.setItems(client_list);
				    }
				    
				    public void setProductChoice() {
				    	product_select.setItems(product_list);
				    }
				    
				   public void StartMachine() {
					   
						    machine.setTurnedOn(true);
						    macine_message.setText("machine has started");
						    setProductChoice();
						    setClientChoice();
					   
				   }
				   









}

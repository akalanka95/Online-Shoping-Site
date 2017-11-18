$(function(){
	
	switch(menu){
	
	case 'About us':
	  $('#about').addClass('active');
	  break;
	
	case 'Home':
		  $('#home').addClass('active');
		  break;
	
	case 'Contact':
		  $('#contact').addClass('active');
		  break;
		
	case 'Manage Products':
		  $('#manageProducts').addClass('active');
		  break;
		  
	default:
		 $('#products').addClass('active');
	 	 $('#a_'+menu).addClass('active');
		 break;
	
	}
	
	
	
	var $table = $('#productListTable');
	
	if($table.length){
		
		var jsonUrl ='';
		
		if(window.categoryId == ''){
			jsonUrl = window.root + '/json/data/all/products';
			console.log(window.root);
		}else{
			jsonUrl = root +'/json/data/category/'+categoryId+'/products';
		}
		
		console.log('Inside the table');
		 $table.DataTable( {
		        
		        pageLength:5,
		        lengthMenu : [[3,5,10,-1],["3 Records","5 Records","10 Records","All"]],
		        ajax :{
		        	url : jsonUrl,
		        	dataSrc : ''
		        },
		        columns : [
		        	{
		        		data : 'code',
		        		mRender : function(data,type,row){
		        			return '<img src="'+window.root+'/resources/images/'+data+'.jpg" class="dataTableImg">';
		        		}
		        	},
		        	{
		        		data : 'name'
		        	},
		        	{
		        		data : 'brand'
		        	},
		        	{
		        		data : 'unit_price',
		        		mRender : function(data,type,row){
		        			return '&#8377; ' + data;
		        		}	
		        	},
		        	{
		        		data : 'quantity',
		        		mRender : function(data,type,row){
		        			if(data <1){
		        				return "<span style='color:red'>Out of Stock!</span>";
		        			}
		        		return data;
		        		}
		        	},
		        	{
		        		data : 'id',
		        		bSortable :false,
		        		mRender : function(data,type,row){
		        			var str = '';
		        			str += '<a href="'+window.root+'/show/'+data+'/products" class="btn btn-primary"><i class="fa fa-eye" aria-hidden="true"></i></a> &nbsp';
		        			
		        			if(row.quantity <1){
		        				str += '<a href="javascript:void(0)"  class="btn btn-success disabled"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>' ;
			        			
		        			}else{
		        				str += '<a href="'+window.root+'/cart/add/'+data+'/products" class="btn btn-success"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>' ;
			        			
		        			}
		        			
		        			
		        			
		        			
		        			return str;
		        		}
		        	}
		        ]
		 });
	}
	
	//dismissing the alert after 3 seconds
	var $alert = $('.alert');
	
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow');
		},3000)
	}
		
	
	//-------------------------------
	
	
	
	//admin product table
	
	
var $adminProductTable = $('#adminProductsTable');
	
	if($adminProductTable.length){
		
		var jsonUrl = window.root + '/json/data/admin/all/products';
		
		console.log("inside the dable admin product");
		
		$adminProductTable.DataTable( {
		        
		        pageLength:5,
		        lengthMenu : [[3,5,10,-1],["3 Records","5 Records","10 Records","All"]],
		        ajax :{
		        	url : jsonUrl,
		        	dataSrc : ''
		        },
		        columns : [
		        	{
		        		
		        		data: 'id'
		        	},
		        	{
		        		data : 'code',
		        		mRender : function(data,type,row){
		        			return '<img src="'+window.root+'/resources/images/'+data+'.jpg" class="adminDataTableImage">';
		        		}
		        	},
		        	{
		        		data : 'name'
		        	},
		        	{
		        		data : 'brand'
		        	},
		        	{
		        		data : 'quantity',
		        		mRender : function(data,type,row){
		        			if(data <1){
		        				return "<span style='color:red'>Out of Stock!</span>";
		        			}
		        		return data;
		        		}
		        	},
		        	{
		        		data : 'unit_price',
		        		mRender : function(data,type,row){
		        			return '&#8377; ' + data ;
		        		}	
		        	},
		        	
		        	{
		        		data : 'is_active',
		        		bSortable : false,
		        		mRender : function(data,type,row){
		        			
		        			var str = '';
		        			
		        			str += '<label class="switch">';
		        			
		        			if(data){
		        				 str +='<input type="checkbox" checked="checked" value="'+row.id+'"/>' ;
					    			
		        			}else{
		        				 str +='<input type="checkbox"  value="'+row.id+'"/>' ;
		     			    	
		        			}
		        			
		    						
		    				 str += '<div class="slider"></div></label>';
								return str;
		        			
		        		}
		        			
		        			

		        		},
		        		{
		        			data : 'id',
		        			dSortable : false ,
		        			mRender : function(data,type,row){
		        			
		        				var str ='';
		        				
		        			 str += '<a href="'+window.root+'/manage/'+data+'/products" class="btn btn-warning">';
		        			str +='<i class="fa fa-pencil-square-o" aria-hidden="true"></i> </a>';
		        			 
		        				return str;
		        			}
		        			
		        		
		        	}
		        ],
		        
		        initComplete: function(){
		        	var api = this.api();
		        	api.$('.switch input[type="checkbox"]').on('change',function(){
		        		
		        		var checkbox = $(this);
		        		var checked = checkbox.prop('checked');
		        		var dMsg = (checked)? 'You want to activate the Product?':
		        							  'You want to deactivate the Product?';
		        		var value = checkbox.prop('value');
		        		bootbox.confirm({
		        			size : 'medium',
		        			title: 'Product Activation and Deactivation',
		        			message : dMsg,
		        			callback : function(confirmed){
		        			if(confirmed){
		        				
		        				
		        			
		        			var activationUrl = window.root + '/manage/product/'+value+'/activation';
		        			$.post(activationUrl ,function(data){
		        				
		        				bootbox.alert({
	        						size : 'medium',
	        						title : 'Information',
	        						message : data
	        					});
		        				
		        				
		        			});
		        			
		        					
		        				}else{
		        					checkbox.prop('checked', !checked);
		        				}
		        			}
		        		});
		        		
		        	});
		        }
		 });
	}
	
	var $categoryForm = $('#categoryForm');
	if($categoryForm.length){
		$categoryForm .validate({
			
			rules:{
				name : {
					required : true,
					minlength : 2
				},
				
				description :{
					required:true
				}
			},
			
			messages :{
				
				name : {
					required : 'Please add the Category Name!',
					minlength : 'The Category name should not be less than 2 characters'
				},
				description:{
					required : 'Please add a description!'
				}
			},
			
			errorElement : 'em',
			errorPlacement : function(error , element){
				error.addClass('help-block');
				error.insertAfter(element);	
			}
		});
		
	}
	
	
	
});




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
		        		data : 'quantity'
		        	},
		        	{
		        		data : 'id',
		        		bSortable :false,
		        		mRender : function(data,type,row){
		        			var str = '';
		        			str += '<a href="'+window.root+'/show/'+data+'/products" class="btn btn-primary"><i class="fa fa-eye" aria-hidden="true"></i></a> &nbsp';
		        			str += '<a href="'+window.root+'/cart/add/'+data+'/products" class="btn btn-success"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>' ;
		        			return str;
		        		}
		        	}
		        ]
		 });
	}
		
});




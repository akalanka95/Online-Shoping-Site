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
		
});
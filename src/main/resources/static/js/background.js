
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch("/img/background.jpg");
    
    /*
        Form validation
    */
    $('.login_assets-form input[type="text"], .login_assets-form input[type="password"], .login_assets-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('.login_assets-form').on('submit', function(e) {
    	
    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
    		if( $(this).val() === "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    	
    });
    
    
});

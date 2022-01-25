/**
 * 
 */
 
 
$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();			
		var href = $(this).attr('href');	
		$.get(href, function(year, status){
			$('#idEdit').val(year.id);
			$('#nameEdit').val(year.name);			
		});					
		$('#editModal').modal();
	});
	
	$('table #deleteButton').on('click', function(event){
		event.preventDefault();		
		var href= $(this).attr('href');		
		$('#confirmDeleteButton').attr('href', href);		
		$('#deleteModal').modal();
	});
	
	
	
	
	$('table #editgButton').on('click',function(event){
		event.preventDefault();			
		var href = $(this).attr('href');	
		$.get(href, function(groupt, status){
			$('#idEdity').val(groupt.id);
			$('#nameEdity').val(groupt.name);			
		});					
		$('#editGrouptModal').modal();
	});
	
	$('table #deletegButton').on('click', function(event){
		event.preventDefault();		
		var href= $(this).attr('href');		
		$('#confirmDeleteButtony').attr('href', href);		
		$('#deleteGrouptModaly').modal();
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	$('table #editsemesterButton').on('click',function(event){
		event.preventDefault();			
		var href = $(this).attr('href');	
		$.get(href, function(semester, status){
			$('#idEditsemester').val(semester.id);
			$('#nameEditsemester').val(semester.name);			
		});					
		$('#editsemesterModal').modal();
	});
	
	$('table #deletesemisterButton').on('click', function(event){
		event.preventDefault();		
		var href= $(this).attr('href');		
		$('#confirmDeleteButtonsemester').attr('href', href);		
		$('#deletesemisterModal').modal();
	});
	
	
	
	
	
	
	$('table #editAdminButton').on('click',function(event){
		event.preventDefault();			
		var href = $(this).attr('href');	
		$.get(href, function(user, status){
			$('#idEditu').val(user.id);
			$('#nameEditu').val(user.name);	
			$('#unameEditu').val(user.uname);			
		});					
		$('#editAdminModal').modal();
	});
	
	$('table #deleteadminButton').on('click', function(event){
		event.preventDefault();		
		var href= $(this).attr('href');		
		$('#confirmDeleteButtonUser').attr('href', href);		
		$('#deleteUserModal').modal();
	});
	
	
	
	
	
	
	
	
	
	$('.pice #photoButton').on('click',function(event) {
	   event.preventDefault();
	   var href = $(this).attr('href');
	   $('#photoModal #userPhoto').attr('src', href);
	   $('#photoModal').modal();		
    });









});


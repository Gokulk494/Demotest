function register() {
    var firstName = document.getElementById('firstName').value;
    var lastName = document.getElementById('lastName').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    validateField(firstName, 'firstNameError');
    validateField(lastName, 'lastNameError');
    validateField(email, 'emailError');
    validateField(password, 'passwordError');

    // Check if any error message is displayed
    var errorMessages = document.querySelectorAll('.error-message');
    for (var i = 0; i < errorMessages.length; i++) {
        if (errorMessages[i].innerText !== '') {
            return; // Don't proceed if there are error messages
        }
    }

    // Your registration logic here

    // Show SweetAlert on successful registration
    Swal.fire({
        title: 'Registration Successful!',
        text: 'Thank you for registering.',
        icon: 'success',
        confirmButtonColor: '#9526a9'
    });
}

function validateField(value, errorElementId) {
    var errorElement = document.getElementById(errorElementId);
    if (!value) {
        errorElement.innerText = 'Please fill out this field.';
    } else {
        errorElement.innerText = '';
    }
}

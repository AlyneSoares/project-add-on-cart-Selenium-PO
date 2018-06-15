"@fixture Criando conta de User no site";
"@page http://demo.cs-cart.com/";

'@test'['Criar conta de usuario'] = {
    '1.Clicar no menu':function () {
        act.click(':containsExcludeChildren(My Account)');
    },

    '2.Clicar em Registre-se':function () {
        act.click(':containsExcludeChildren(Register)');
    },
    
    '3.Digitar Nome': function () {
        act.type($('#email'),'email@email.com');
    },

    '4.Digitar senha': function () {
        act.type($('#password1'), 'senha');
    },

    '5.Repetir senha': function () {
        act.type($('#password2'), 'senha');
    },

    '6.Digitar aniversario': function () {
        act.type($('#birthday'), '01/04/1999');
    },

    '7.Clica para fechar calendario':function () {
        act.click('.ty-age-verification-birthday > div:nth-child(1) > label:nth-child(1)');
    },

    '8.Not a ROBOT!!': function () {
        act.click('#recaptcha-anchor');
    },

    '9.Clicar Register': function () {
        act.click('.ty-profile-field__buttons > button:nth-child(1)')
    }
    
};
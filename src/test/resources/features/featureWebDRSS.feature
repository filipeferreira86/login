#language: pt

Funcionalidade: Permitir login no email

	Cenário: Fazer login com sucesso
		Dado que estou na pagina "http://192.168.0.210:8888/WEB_DRGX2/servlet/wcoindex"
		Quando eu informar "teste.email.gx2@gmail.com" no campo "identifier" #name
		E cliar no botão "identifierNext" #id
		E informar "gx2@7242" no campo "password"
		E cliar no botão "passwordNext" #id
		Então deve logar no Gmail apresentando mensagem "mensagem" 

		Esquema do Cenário: Fazer login com falha
		Dado que estou na pagina "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin"
		E cliar no botão "identifierNext" #id
		Quando eu informar <login> no campo "login"
		E cliar no botão "passwordNext" #id
		E informar <senha> no campo "password"
		Então não deve logar no Gmail apresentando mensagem "mensagem"
		|login   			 							|senha					| 
		|teste.email1.gx2@gmail.com |gx2@7242				|
		|teste.email.gx2@gmail.com 	|gx2@724222			|
		|teste.email1.gx2@gmail.com |gx2@724				|

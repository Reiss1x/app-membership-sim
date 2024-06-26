Instruções para rodar e testagem:


abrir docker desktop
acessar o root do programa
docker-compose up -d --build
utilize o arquivo postman disponibilizado para testar as requisições ou acesse os endpoints nos seguintes endereços:
Todos as requisições tem essa base: http://localhost:8765

Assinaturas:
	Retorna todas por tipo (TODAS, ATIVAS OU CANCELADAS) (GET):
	/cadastramento/servcad/assinaturas/{TIPO}
	Retorna por código de assinatura (GET):
	/cadastramento/servcad/asscod/{CÓDIGO}
	Retorna por código de aplicativo (GET):
	/cadastramento/servcad/assapp/{CÓDIGO}
	Retorna por código de cliente (GET):
	/cadastramento/servcad/asscli/{CÓDIGO}
	Checa se assinatura está válida por código de assinatura (GET):
	/assinaturas-validas/assinvalidas/{CÓDIGO}
	
	Cria Assinatura (POST):
	/cadastramento/servcad/assinaturas
	exemplo JSON:
	{
		"codCli": 10,
    		"codApp": 10
	}

Clientes:
	Retorna todos os clientes (GET):
	/cadastramento/servcad/clientes
	
	Cria cliente (POST):
	/cadastramento/servcad/clientes/
	{
    		"nome": "clienteTeste",
    		"email": "teste@gmail.com"
	}

	Atualiza cliente por código (POST):
	/cadastramento/servcad/clientes/update
	{
    		"cod": 11,
    		"nome": "clienteUpdate",
		"email": "update@gmail.com"

	}

Aplicativos:
	Retorna todos aplicativos (GET):
	/cadastramento/servcad/aplicativos
	
	Cria aplicativo (POST):
	/cadastramento/servcad/aplicativos
	{
    		"nome": "appteste",
    		"custoMensal": 4.44
	}
	
	Atualiza aplicativo (PATCH):
	/cadastramento/servcad/aplicativos/1

Pagamento:
	Registra pagamento (POST):
	/pagamentos/registrarpagamento
	{
  		"codAssinatura": 5,
  		"valorPago": 10.0,
  		"dataPagamento": "2024-06-19"
	}


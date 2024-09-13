Escopo do Projeto: Cadastro de Cliente com Integração API ViaCEP
O objetivo deste projeto é desenvolver um sistema para o cadastro de clientes, com uma funcionalidade diferenciada na inserção do endereço. O cliente fornecerá apenas suas informações pessoais, o número do apartamento ou casa e o CEP (Código de Endereçamento Postal). A partir dessas informações, o sistema irá completar automaticamente o restante do endereço utilizando a API ViaCEP.
Detalhes do Escopo:
1.	Cadastro de Cliente: O sistema permitirá que o cliente insira seus dados pessoais, incluindo nome, cpf, idade e e-mail, etc.
2.	Informações do Endereço:
o	O cliente informará apenas o número do apartamento/casa e o CEP.
o	O sistema irá buscar e preencher automaticamente os campos restantes do endereço (logradouro, bairro, cidade, estado) utilizando a API ViaCEP.
3.	Integração com a API ViaCEP:
o	O sistema fará uma requisição à API ViaCEP para obter as informações do endereço com base no CEP fornecido.
o	Os dados retornados pela API serão usados para preencher automaticamente os campos do endereço no formulário de cadastro.

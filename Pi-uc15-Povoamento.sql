insert into clientes(nome,cpf,telefone,endereco,email) values
("Lucas carvalho","098.231.726-00","(21) 94258-0121","avendida das flores 23","lucas@gmail.com"),
("Manoel dos santos","087.981.843-12","(21)97213-0175","rua dos santos 256","Manoe@gmail.com"),
("Luiza ribeiro","451.231.782-90","(21) 91877-7562","rua primeiro de marco","Luiza@gmail.com");


insert into funcionarios(nome,cpf,telefone,genero) values
("Eduardo pereira","021.231.456-21","(21) 93211-2390","M"),
("Larissa moreira","892.123.390-60","(21) 98812-1900","F"),
("Rodrigo peixoto","901.876.568-53","(21) 98901-8562","M");


insert into produtos(nome,fabricante,estoque,valor,plataforma) values
("Watch dogs 2","Ubisoft",40,365.00,"Playstation4/Xbox one"),
("Mario kart 8","Nintendo",25,400.00,"Nintendo switch"),
("Pokemon scarlet","Game freak",10,450.00,"Nintendo switch");


insert into vendas(quantidade_comprada,data_compra,funcionario_id,cliente_id,produto_id) values
(2,"2025-10-12",2,2,5),
(1,"2025-10-20",3,3,4),
(1,"2025-09-10",4,4,3),
(1,"2025-01-20",1,1,1);
# esqueleto

## Projetinho básico com uma form de clientes e uma Bootstrap-table.

No eclipse basta ir em _File -> Import... -> Maven -> Existing Maven Projects_.

É preciso criar um banco de dados vazio com usuário e senha determinados no **db.properties**. 
Por padrão, o banco e o usuário e senha são todos '*exemplo*'

```
#Database DESENVOLVIMENTO
dev.db.driver=org.postgresql.Driver
dev.db.url=jdbc:postgresql://localhost:5432/exemplo
dev.db.username=exemplo
dev.db.password=exemplo
```

Por padrão o projeto espera um banco de dados ```Postgre```. Para outros bancos basta inserir o driver correspondente no **pom.xml**.

Por default a aplicação loga no profile de *DESENVOLVIMENTO* para logar em produção é preciso adicionar a propriedade ```spring.profiles.active=prod``` no arquivo **catalina.properties** do seu Tomcat.
Com isso a aplicação vai usar as configurações de *prod*

Apesar de usar JPA, por baixo dos panos está usando a implementação do Hibernate.
O Hibernate está configurado para criar as tabelas automaticamente com a instrução do *hbm2ddl* em **update**. Essa configuração está na última linha do **db.properties**.

# esqueleto

## Projetinho básico com uma form de clientes e uma Bootstrap-table.

É preciso criar um banco de dados vazio com usuário e senha determinados no **db.properties**. 
Por padrão o usuário e senha são *exemplo*

```
#Database DESENVOLVIMENTO
dev.db.driver=org.postgresql.Driver
dev.db.url=jdbc:postgresql://localhost:5432/exemplo
dev.db.username=exemplo
dev.db.password=exemplo
```

Por default a aplicação loga no profile de *DESENVOLVIMENTO* para logar em produção é preciso adicionar a propriedade ```#spring.profiles.active=prod``` no arquivo **catalina.properties*** do seu Tomcat.
Com isso a aplicação vai usar as configurações de *prod*

O Hibernate está configurado para criar as tabelas automaticamente com a instrução do *hbm2ddl* em **update**. Essa configuração está na última linha do **db.properties**.

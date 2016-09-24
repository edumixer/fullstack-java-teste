# Autor

Alessandro Rodrigo Franco (rfalessandro@gmail.com)

### Tecnologias utilizadas


# Back-end

	. Banco de dados MariaDB ( Fork do MySql antes da Oracle comprar )
	. JEE puro com context dependency injection
	. JPA	 
	. Hibernate

# Front-end

	. Single Page Application
	. Angular Material

# Ambinte de desenvolvimento

	. Eclipse
	. JDK 8
	. Servidor Wildfly 10

# Configuração do servidor

	O Servidor utilizado foi o Wildfly 10 Final e foi criado o conector do banco de dados ( mariadb-java-client-1.5.2.jar ) como modulo.
Por questões de seguraça as conexões do banco de dados ficam no servidor e não são vistas pelos desenvolvedores da aplicação, para isso crie a pasta modules/system/layers/base/com/mariadb/main/ no wildfly, coloque o jar do mariadb e crie o module.xml com o seguinte conteudo:

	<?xml version="1.0" encoding="UTF-8"?>
	<module xmlns="urn:jboss:module:1.3" name="com.mariadb">
	    <resources>
	        <resource-root path="mariadb-java-client-1.5.2.jar"/>
	    </resources>
	    <dependencies>
	        <module name="javax.api"/>
        	<module name="javax.transaction.api"/>
	    </dependencies>
	</module>

	Depois configure a conexão do banco de dados, abre o arquivo standalone/configuration/standalone.xml do wildfly. Procure a linha de datasource e adicione a configuração de conexão do banco.

  	  <datasource jndi-name="java:/jboss/datasources/PedidoContab" pool-name="SinaxDS" enabled="true">
	
                    <connection-url>jdbc:mariadb://localhost:3306/sinax</connection-url>
                    <driver>mariadb</driver>
                    <pool>
                        <min-pool-size>1</min-pool-size>
                        <max-pool-size>5</max-pool-size>
                        <prefill>true</prefill>
                    </pool>
                    <security>
                        <user-name>sInAdax</user-name>
                        <password>Ad#s1n4x!@#</password>
                    </security>
                </datasource>
                <drivers>
                    <driver name="mariadb" module="com.mariadb"/>
                </drivers>
	  </datasources>
	
	Feito isso o arquivo persistence.xml ira buscar a JNDI java:/jboss/datasources/PedidoContab para conectar com o banco de dados. 
	Devido ao fato do Wildfly ser completo a lib do Hibernate que foi usado está dentro dele e não no projeto do módulo do back-end.







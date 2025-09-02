# bzn-gai-services-identity
Micro-serviço que fornece para o aplicativo GAI as funcionalidades dos usuários das aplicações, disponibilizando as informações de credenciais, papeis , perfils e etc.


mvn clean install -s ./settings.xml

C:\projetos\brazona\recursos\settings.xml

## Escopo de trabalho

### Funcionalidades

- name: credentials - ok
  description: Funcionalidade de credenciais do Gai Identity
- name: addresses
  description: Funcionalidade de endereços do Gai Identity
- name: contact
  description: Funcionalidade de contatos do Gai Identity  
- name: persons
  description: Funcionalidade de pessoas do Gai Identity
- name: institution
  description: Funcionalidade de instituição do Gai Identity
- name: profiles
  description: Funcionalidade de perfis do Gai Identity

### tarefas

* Definir contrato openapi
* Modelar banco de dados ( script sql )
* Desenvolver ou Implementar código ( algoritmo )

```text
1. entity
2. repository
3. provider
4. mapper
5. service
6.controller
```

* Implementar classes app/domain/infra
* Implementar javadoc
* Implementar openapi swagger


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  
    <title>Aplicação Teste</title>
    
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/URI.js/1.17.0/URI.min.js"></script>
    
    <script type="text/javascript">
       var contextPath = "${pageContext.request.contextPath}";
    </script>
     
    
  </head>

  <body role="document">
     

  <div class="container">
  
    <div class="jumbotron">
      <h2></h2>
    </div>

    <div class="row">
    
      <div class="panel panel-default">
        <div class="panel-body">
          <h3>Cadastro de Cliente
          </h3>
          
          <div class="spacer-vertical40"></div>

          <div class="row">
            <div class="col-lg-12">

              <form class="form-horizontal" id="clienteform" action="#" method="POST">
              
                <input type="hidden" id="idCliente" name="idCliente" value="${idCliente}" >
      
                <div class="row">
                  <div class="col-lg-12 col-md-12">
                  
                    <div class="form-group">
                      <label for="nome" class="control-label col-sm-2 col-md-2">Razão Social</label>
                      <div class="col-sm-10 col-md-8">
                        <input type="text" class="form-control" id="razaosocial" name="razaosocial">
                      </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="login" class="control-label col-sm-2 col-md-2">Nome Fantasia</label>
                        <div class="col-sm-8 col-md-6">
                          <input type="text" class="form-control" id="nomefantasia" name="nomefantasia">
                        </div>
                        <div class="col-lg-2 col-md-2 col-sm-2">
                          <div class="checkbox">
                            <label>
                              <input type="checkbox" id="ativo" name="ativo" value="true"> Ativo
                            </label>
                          </div>
                        </div>

                    </div>

                    <div class="form-group">
                      <label for="login" class="control-label col-sm-2 col-md-2">CNPJ</label>
                      <div class="col-lg-4 col-md-4 col-sm-6">
                        <input type="text" class="form-control cnpj" id="cnpj" name="cnpj">
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="login" class="control-label col-sm-2 col-md-2">Email</label>
                      <div class="col-lg-4 col-md-4 col-sm-6">
                        <input type="text" class="form-control" id="email" name="email">
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="cep" class="control-label col-sm-2 col-md-2">CEP</label>
                      <div class="col-lg-2 col-md-3 col-sm-4 ">
                        <input type="text" class="form-control" id="cep" name="cep" maxlength="8">
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="login" class="control-label col-sm-2 col-md-2">Endereço</label>
                      <div class="col-sm-10 col-md-8">
                        <input type="text" class="form-control" id="logradouro" name="logradouro">
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="login" class="control-label col-sm-2 col-md-2">Número</label>
                      <div class="col-lg-2 col-md-3 col-sm-4">
                        <input type="text" class="form-control" id="numero" name="numero">
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="login" class="control-label col-sm-2 col-md-2">Complemento</label>
                      <div class="col-sm-10 col-md-8">
                        <input type="text" class="form-control" id="complemento" name="complemento">
                      </div>
                    </div>

                    <div class="form-group">
                      <label for="login" class="control-label col-sm-2 col-md-2">Bairro</label>
                      <div class="col-lg-4 col-md-4 col-sm-6">
                        <input type="text" class="form-control" id="bairro" name="bairro">
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="login" class="control-label col-sm-2 col-md-2">Estado</label>
                      <div class="col-lg-4 col-md-4 col-sm-6">
                        <select class="form-control" id="estado" name="estado">
                          <option value="AC">Acre </option>
                          <option value="AL">Alagoas </option>
                          <option value="AP">Amapá </option>
                          <option value="AM">Amazonas </option>
                          <option value="BA">Bahia </option>
                          <option value="CE">Ceará </option>
                          <option value="DF">Distrito Federal </option>
                          <option value="ES">Espírito Santo </option>
                          <option value="GO">Goiás </option>
                          <option value="MA">Maranhão </option>
                          <option value="MT">Mato Grosso </option>
                          <option value="MS">Mato Grosso do Sul </option>
                          <option value="MG">Minas Gerais </option>
                          <option value="PA">Pará </option>
                          <option value="PB">Paraíba </option>
                          <option value="PR">Paraná </option>
                          <option value="PE">Pernambuco </option>
                          <option value="PI">Piauí </option>
                          <option value="RJ">Rio de Janeiro </option>
                          <option value="RN">Rio Grande do Norte </option>
                          <option value="RS">Rio Grande do Sul </option>
                          <option value="RO">Rondônia </option>
                          <option value="RR">Roraima </option>
                          <option value="SC">Santa Catarina </option>
                          <option value="SP">São Paulo </option>
                          <option value="SE">Sergipe </option>
                          <option value="TO">Tocantins</option>
                        </select>
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="login" class="control-label col-sm-2 col-md-2">Cidade</label>
                      <div class="col-lg-4 col-md-4 col-sm-6">
                        <input type="text" class="form-control" id="cidade" name="cidade">
                      </div>
                    </div>
                    
                  </div>
                  
                </div>
                
                
                <div class="row">

                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <div class="">
                      <button type="button" class="btn btn-warning" id="btnLimpar">
                        <i class="fa fa-file-o"></i> Limpar</a>
                      </button>
                    </div>            
                  </div>
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <div class="pull-right">
                      <button type="button" class="btn btn-primary" id="btnSalvar">
                        <i class="fa fa-floppy-o"></i>
                        Salvar Alterações
                      </button>
                    </div>
                  </div>

                </div>

              </form>
                

              <hr>


            </div>

              <div class="row" >
                <div class="col-lg-12">
                
                  <div class="spacer-vertical10"></div>
                  
                      <div class="col-lg-10 col-md-10">
                        <table  
                           id="tableclientes"
                           data-toggle="table"
                           data-url="${context}/clientes"
                           data-height="300"
                           data-side-pagination="server"
                           data-pagination="true"
                           data-page-size=4
                           data-locale = "pt_BR"
                           data-query-params="queryParams" >
                          <thead>
                            <tr>
                                <th data-field="razaosocial">Razão Social</th>
                                <th data-field="nomefantasia">Nome</th>
                                <th data-field="dominio">Domínio</th>
                                <th data-field="cnpj">CNPJ</th>
                                <th data-field="email">Email</th>
                                <th data-field="telefone" data-formatter="telefoneFormatter">Telefone</th>
                                <th data-field="qtd_tit">Qtd. Títulos em Aberto</th>
                            </tr>
                          </thead>
                        </table>
                      </div>
              
                </div>
              </div>

          </div>

          <div class="spacer-vertical20"></div> 

          <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
              <div class="">
                <a class="btn btn-default" href="${context}" >
                  <i class="fa fa-arrow-left"></i>
                  Voltar para Cadastro de Clientes</a>
              </div>            
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
              <div class="pull-right">
                <a class="btn btn-default" href="${context}">Sair</a>
              </div>
            </div>
          </div>
          
        </div>
      </div>
    </div>
      
  </div> <!-- /container -->



<style type="text/css">

#linkaddtelefone{
    color: #326432;
    margin: 2px;
    display: block;
    margin-top: 7px;
    white-space: nowrap;
}

#tableclientes tr{
  cursor: pointer;
}


</style>




<script type="text/javascript">

    var pagina = 0, limit = 6;

    function queryParams(params) {

        params.pageNumber = $('#tableclientes').bootstrapTable('getOptions').pageNumber;
        
        return params;
    };
    
    function telefoneFormatter(value, row) {
        
        if ( row.telefones && row.telefones.length > 0 )
            return row.telefones[0].ddd + " " + row.telefones[0].numero;
        else
          return "";
    }

    var editarClienteSelecionado = function( e, row, el )
    {
        if ( row == null ) 
            return;
        
        if ( row.idCliente == null || row.idCliente == 0 ) {
            return false;
        } else {
            // setando o ID no form e buscando os dados
            $("#idCliente").val( row.idCliente );
            getDados();
        }
    };


    var maskBehaviorTel = function (val) {
        return val.replace(/\D/g, '').length === 11 ? '00000-0000' : '0000-00009';
    };
      
    var optionsTel = {onKeyPress: function(val, e, field, options) {
              field.mask(maskBehaviorTel.apply({}, arguments), options);
          }
    };



    var formReset = function( form )
    {
        $(form).find(':input').not(':button, :submit, :reset, :checkbox, :radio').val('');
        $(form).find(':checkbox, :radio').prop('checked', false);
    }


    var getDados = function()
    {
        var idCliente = $("#idCliente").val();
        
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: "${context}/clientes/"+idCliente,
            dataType: 'json'
        }).done( function(json) {
            
            formReset( $('#clienteform'));
            $('#clienteform').populate(json);
        });
    };

    var salvar = function(){
        
        var dados = JSON.stringify( $('#clienteform').serializeJSON() );
        
        $.ajax({
            
            type: 'POST',
            contentType: 'application/json',
            url: "${context}/clientes",
            dataType: 'json',
            data: dados 
            
        }).done( function(json){ 

            if ( json.idCliente && json.idCliente > 0){
                
                $("#idCliente").val( json.idCliente );

                $('#tableclientes').bootstrapTable('refresh');
            }
        });
        
    };


    $(function(){
        
        $('#tableclientes').on('click-row.bs.table', function( e, row, el ){
            editarClienteSelecionado( e, row, el );
        });

        $('#btnSalvar').on('click', salvar);
        
        $(".cnpj").mask('00.000.000/0000-00'); 
        $(".inteiro").mask('000');        
        $(".money").mask('000.000,00', {reverse: true});
        
        getDados();
        
        $("#btnLimpar").click( function(){
            formReset( $('#clienteform'));
        });
        
        
    });

</script>


<script type="text/javascript" src="${context}/js/required/jquery.serializejson.js" defer></script>
<script type="text/javascript" src="${context}/js/required/jquery.populate.js" async></script>
<script type="text/javascript" src="${context}/js/required/jquery.mask.min.js" defer></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.0/bootstrap-table.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.0/locale/bootstrap-table-pt-BR.min.js" charset="UTF-8"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.0/bootstrap-table.min.css" rel="stylesheet">

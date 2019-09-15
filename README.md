	@GenericGenerator(name = "sequence-generator",strategy = "sequence") 
  // adresi adress_id olarak PK yapmaya yarıyor
  
	@CollectionId(columns = {@Column(name="adress_id")},generator ="sequence",type = @Type(type = "int")) 
  //adress_id foreign key alnı olarak belirliyoruz
  
  fetchType.LAZY = ilgili nesne(Employee) cağrıldığında o da çağrılır.ilgili nesne çağrılcak diğeri nesne ihtiyaçı olduğunda
  fetchType.EAGER = ilşikli olduğu nesne yüklendiğinde çağrılır

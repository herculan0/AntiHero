```java
ImageView fotoDoCamarada;
ImageView herois;
LinearLayout inicio;
LinearLayout resultado;
Button botao;
TextView textView;
ArrayList<String> fotos = new ArrayList<String>();
int CAMERA_REQUEST = 1888;
```

Aqui iniciamos as variáveis necessárias, incluindo a instanciação da ArrayList fotos e a CAMERA_REQUEST para receber o valor ao retornar para o App assim que o usuário tira a foto.

```java
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        herois = findViewById(R.id.heroi);
        fotos.add("baco");
        fotos.add("coringa");
        fotos.add("deadpool");
        fotos.add("gracehopper");
        fotos.add("jaspion");
        fotos.add("mrrobot");
        fotos.add("mulhermaravilha");
        fotos.add("neo");
        fotos.add("rochelle");
        fotos.add("samueljackson");
        fotos.add("superchoque");
        fotos.add("terrycrews");
        fotos.add("trinity");
        fotos.add("watchmen");

        inicio = findViewById(R.id.inicio);
        resultado = findViewById(R.id.resultado);
        botao = findViewById(R.id.botao);
        fotoDoCamarada = findViewById(R.id.foto);
        textView = findViewById(R.id.textView);
```

aqui alocamos os objetos dentro do OnCreate e utilizamos a Classe R para pegar da View e colocar no Controlador.



```java
botao.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }
```

Através do Botão iniciamos a Intent para capturar a foto da Pessoa assim que ela clica no botão.

```
private String sortear() {
    Random sortiador = new Random();
    int sorteado = sortiador.nextInt(fotos.size());
    return fotos.get(sorteado);
}
```

Aqui criamos o método com a função Random para sortear uma foto de acordo com tamanho da Lista, ou seja independente do tamanho da lista/quantidade de fotos, atribuimos o índice sorteado à foto sorteada.



```java
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
        inicio.setVisibility(View.GONE);
        resultado.setVisibility(View.VISIBLE);
        Bitmap photo = (Bitmap) data.getExtras().get("data");
        fotoDoCamarada.setImageBitmap(photo);
        exibirSorteado();
    }
```

Criamos um  método recebendo o código da requisição, resultado da requisição e os dados da Intent. Então se o resultado recebido for o mesmo estipulamos que o Layout inicio "se vai" e dá espaço ao Layout com as fotos(da pessoa e do heroi) e criamos um Bitmap com a photo que receberá o dado da Intent, que no caso é a foto do usuário. Assim chamamos o método de exibirSorteado:

```java
private void exibirSorteado() {
    String fotoSorteado = sortear();
    textView.setText("Você se parece com " + fotoSorteado);
    herois.setImageResource(getResources().getIdentifier(fotoSorteado,"drawable", "com.example.antihero"));
}
```

Que é o método que atribui a foto sorteada e exibe o texto com o nome da foto que tem o nome do heroi/personalidade famosa.
cd ~/workspace/controle-gastos/
mvn clean install

cd ~/workspace/controle-gastos/controle-gastos-react/
npm run build

cd ~/workspace/controle-gastos/controle-gastos-docker/

if [ ! "$(docker ps -a -q -f name=controle-gastos-db)" ]; then
    if [ "$(docker ps -aq -f status=exited -f name=controle-gastos-db)" ]; then
        # cleanup
        echo "O container controle-gastos-db já existe. Não iniciando o serviço postgres."
    fi
    docker-compose up -d postgres
fi


echo "Removendo container controle-gastos-app"
docker stop controle-gastos-app && docker rm controle-gastos-app
echo "Criando container controle-gastos-app"
docker-compose up -d app
docker logs -f controle-gastos-app

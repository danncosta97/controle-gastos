cd ~/workspace/controle-gastos/
mvn clean install

cd ~/workspace/controle-gastos/controle-gastos-react/
npm run build

cd ~/workspace/controle-gastos/controle-gastos-docker/
# Verifica se o container controle-gastos-db existe
if docker ps -a -q -f name=controle-gastos-db >/dev/null 2>&1; then
    echo "O container controle-gastos-db já existe. Não iniciando o serviço postgres."
else
    echo "Iniciando o container controle-gastos-db e o serviço PostgreSQL..."
    docker-compose up -d postgres
fi
echo "Removendo container controle-gastos-app"
docker stop controle-gastos-app && docker rm controle-gastos-app
echo "Criando container controle-gastos-app"
docker-compose up -d app

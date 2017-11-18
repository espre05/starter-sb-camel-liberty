FROM websphere-liberty:webProfile7
#FROM websphere-liberty
ADD target/prem-orca-1.0-SNAPSHOT.war /opt/ibm/wlp/usr/servers/defaultServer/dropins/
ENV LICENSE accept
EXPOSE 9080

## Running the container locally
# mvn clean install
# docker build -t prem-orca:latest .
# docker run -d --name premcontainer prem-orca
# docker run -p 9080:9080 --name premcontainer prem-orca
# Visit http://localhost:9080/prem-orca/

## Push container to Bluemix
# Install cli and dependencies: https://console.ng.bluemix.net/docs/containers/container_cli_cfic_install.html#container_cli_cfic_install
# docker tag prem-orca:latest registry.ng.bluemix.net/prem-ns/prem-orca:latest
# docker push registry.ng.bluemix.net/prem-ns/prem-orca:latest
# bx ic images # Verify new image

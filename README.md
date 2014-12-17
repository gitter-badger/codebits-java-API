codebits-java-API
=================

[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/pedrorijo91/codebits-java-API?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Sapo Codebits API wrapper in Java. [List of public endpoints available](https://codebits.eu/s/api).

API calls results returned as java.lang.String. You may choose any JSON/XML parser to obtain a JSON/XML object.

> **Note:** Available API contains some issues regarding format choosing, currently not documented. For this reason all API calls allow you to choose between JSON (default) and XML, but take into account that the result may be unexpected when choosing XML (currently waiting answer to get documentation about those issues).
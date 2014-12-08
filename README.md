codebits-java-API
=================

Sapo Codebits API wrapper in Java. [List of public endpoints available](https://codebits.eu/s/api).

API calls results returned as java.lang.String. You may choose any JSON/XML parser to obtain a JSON/XML object.

> **Note:** Available API contains some issues regarding format choosing, currently not documented. For this reason all API calls allow you to choose between JSON (default) and XML, but take into account that the result may be unexpected when choosing XML (currently waiting answer to get documentation about those issues).
curl -X POST -H "Content-Type: application/json" \
	-d '{
		"author": "Erik Naggum",
		"year": "",
		"quotationContent": "Life is too long to know C++ well.",
		"urlImgAssociatedWithIt": ""
	    }' \
	    http://localhost:8080/application
	    
	    
curl -X PUT -H "Content-Type: application/json" \
	-d '{
		"author": "Robert C. Martin",
		"year": "",
		"quotationContent": "Redundant comments are just places to collect lies and misinformation.",
		"urlImgAssociatedWithIt": ""
	}' \
	http://localhost:8080/application/1
	
curl -X DELETE http://localhost:8080/application/3

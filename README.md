{
	"info": {
		"_postman_id": "9f344319-9e5a-46ae-838e-e9fbc366f0f3",
		"name": "E",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "35991395"
	},
	"item": [
		{
			"name": "Hello World",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/hello",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"hello"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get All Products",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/api/products",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"products"
					]
				}
			},
			"response": []
		},
		{
			"name": "get single product",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/api/product/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"product",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "Add Product",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "formdata",
					"formdata": [
						{
							"key": "product",
							"value": "{\n  \"name\":\"DysonV16\",\n  \"description\":\"Cordless vacuum cleaner\",\n  \"brand\":\"Dyson\",\n  \"category\":\"Home Appliances\",\n  \"price\":699.99,\n  \"releaseDate\":\"2025-01-10\",\n  \"stockQuantity\":25,\n  \"productAvailable\":true\n}",
							"contentType": "application/json",
							"type": "text"
						},
						{
							"key": "imageFile",
							"type": "file",
							"src": "/Users/sarthak.paliwal/Documents/avatar.png"
						}
					]
				},
				"url": {
					"raw": "http://localhost:8080/api/product",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"product"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get Image",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "image/png",
						"type": "text",
						"disabled": true
					}
				],
				"url": {
					"raw": "http://localhost:8080/api/product/2/image",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"product",
						"2",
						"image"
					]
				}
			},
			"response": []
		},
		{
			"name": "update Product",
			"request": {
				"method": "PUT",
				"header": [],
				"body": {
					"mode": "formdata",
					"formdata": [
						{
							"key": "product",
							"value": "{\n  \"name\":\"Dyson V17\",\n  \"description\":\"Cordless vacuum cleaner\",\n  \"brand\":\"Dyson1\",\n  \"category\":\"Home Appliances\",\n  \"price\":699.99,\n  \"releaseDate\":\"2025-01-10\",\n  \"stockQuantity\":25,\n  \"productAvailable\":true\n}",
							"contentType": "application/json",
							"type": "text"
						},
						{
							"key": "imageFile",
							"type": "file",
							"src": "/Users/sarthak.paliwal/Documents/avatar.png"
						}
					]
				},
				"url": {
					"raw": "http://localhost:8080/api/products/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"products",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "delete Product",
			"request": {
				"method": "DELETE",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/api/products/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"products",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "Search",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/api/products/search?keyword=DysonV16",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"products",
						"search"
					],
					"query": [
						{
							"key": "keyword",
							"value": "DysonV16"
						}
					]
				}
			},
			"response": []
		}
	]
}


#url="https://login.fitchconnect-dev.com/oauth/token"

#curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "grant_type=authorization_code&code=362ad374-735c-4f69-aa8e-bf384f8602de&redirect_uri=localhost:8080/oauth-callback&client_id=2k1sl51j0ov2i6tuimsbdk2icv&client_secret=me8sku3chvb9t9q77udnf2m578l60b8csgv3j3f4bu1vhj8e3ns" "${url}"


curl --location --request GET 'https://identity-data.fitchconnect-dev.com/v2/users/5f89da1f5b33a1000126a8a9' \
--header 'X-App-Client-Id;' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJodHRwOi8vaWRlbnRpdHktZGF0YS1zZXJ2aWNlOjgwODAvdjIvdXNlcnMvNWY4OWRhMWY1YjMzYTEwMDAxMjZhOGE5Iiwic2NvcGUiOlsidHJ1c3QiXSwiaXNzIjoiaHR0cHM6Ly9sb2dpbi5maXRjaGNvbm5lY3QtZGV2LmNvbSIsImV4cCI6MTYwMzczODE0MywiaWF0IjoxNjAzNzM0NTQzLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiNjMwNmUwZDktODI2ZS00YTFjLWJiNzAtNGM0Nzg0NjE5ZGYzIiwiY2xpZW50X2lkIjoiMmsxc2w1MWowb3YyaTZ0dWltc2JkazJpY3YifQ.DQRClbPSrsfrTN2MHMYN47g2Zknfa1PkBPgrz4isLtM'
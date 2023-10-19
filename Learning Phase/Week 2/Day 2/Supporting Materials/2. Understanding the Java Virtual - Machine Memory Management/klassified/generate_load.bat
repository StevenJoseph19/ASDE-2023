for /L %%l in (0,1,20) do (
    curl http://localhost:9000/postings > nul 2>&1.

done
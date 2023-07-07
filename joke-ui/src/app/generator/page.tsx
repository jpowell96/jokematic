'use client';
import useSWR from 'swr';

 
const fetcher = (url: string) => fetch(url).then((res) => res.json())
 
export default function RandomJoke() {
  const { data, error } = useSWR('http://localhost:8080/api/v1/joke', fetcher)
 
  if (error) return <div>Failed to load</div>
  if (!data) return <div>Loading...</div>
 
  return (
    <div>
      <h1>{data.id}</h1>
      <p>{data.joke}</p>
      <p>{data.punchline}</p>
    </div>
  )
}